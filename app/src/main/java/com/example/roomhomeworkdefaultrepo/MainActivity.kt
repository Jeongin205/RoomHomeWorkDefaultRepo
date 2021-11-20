package com.example.roomhomeworkdefaultrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

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

        val addRunnable = Runnable {
        }

    }
}