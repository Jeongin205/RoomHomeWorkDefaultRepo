package com.example.roomhomeworkdefaultrepo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FriendsAdapter(val friendsList: List<Friends>, private val onClick : (friends: Friends) -> Unit) :
    RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {
    inner class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val number = itemView.findViewById<TextView>(R.id.number_text_view)
        val name = itemView.findViewById<TextView>(R.id.name_text_view)
        val email = itemView.findViewById<TextView>(R.id.email_text_view)
        val mbti = itemView.findViewById<TextView>(R.id.mbti_text_view)

        fun bind(friends: Friends) {
            number.text = friends.number.toString()
            name.text = friends.name
            email.text = friends.email
            mbti.text = friends.mbti
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_friends, parent, false)
        view.setOnClickListener{
            onClick.invoke(friendsList[FriendsViewHolder(view).position+1])
        }
        return FriendsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.bind(friendsList[position])
    }

    override fun getItemCount(): Int = friendsList.size
}