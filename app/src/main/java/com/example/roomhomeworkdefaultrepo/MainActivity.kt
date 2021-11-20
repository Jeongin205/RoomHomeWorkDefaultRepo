package com.example.roomhomeworkdefaultrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDataBase
    private lateinit var friendsList: List<Friends>
    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: FriendsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDataBase.getInstance(this)!!
        mRecyclerView = findViewById(R.id.friend_recycler)
        val nameEditText = findViewById<EditText>(R.id.name_edit_text)
        val emailEditText = findViewById<EditText>(R.id.email_edit_text)
        val mbtiEditText = findViewById<EditText>(R.id.mbti_edit_text)
        val numberEditText = findViewById<EditText>(R.id.number_edit_text)


        val addRunnable = Runnable {
            val newFriend = Friends(
                numberEditText.text.toString(),
                nameEditText.text.toString(),
                emailEditText.text.toString(),
                mbtiEditText.text.toString()
            )
            db.friendDao().insertData(newFriend)
            loadData()
        }

        loadData()


        findViewById<Button>(R.id.save_data_button).setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()
            numberEditText.text = null
            nameEditText.text = null
            emailEditText.text = null
            mbtiEditText.text = null
        }

    }

    private fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            friendsList = db.friendDao().getALl()
            runOnUiThread {
                mAdapter = FriendsAdapter(friendsList) { friends ->
                    CoroutineScope(Dispatchers.IO).launch {
                        db.friendDao().deleteData(Friends(friends.number, friends.name, friends.email, friends.mbti))
                    }
                    loadData()
                }
                mRecyclerView.adapter = mAdapter
                mAdapter.notifyDataSetChanged()
            }
        }
    }
}