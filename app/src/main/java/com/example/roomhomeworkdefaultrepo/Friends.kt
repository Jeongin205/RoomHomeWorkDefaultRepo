package com.example.roomhomeworkdefaultrepo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Friends(
    @PrimaryKey
    var number: String,
    var name: String?,
    var email: String?,
    var mbti: String?
)
