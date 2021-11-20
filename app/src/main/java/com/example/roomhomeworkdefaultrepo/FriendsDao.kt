package com.example.roomhomeworkdefaultrepo

import androidx.room.*

@Dao
interface FriendsDao {
    @Query("SELECT * FROM friends")
    fun getALl() : List<Friends>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(friends: Friends)

    @Delete
    fun deleteData(friends: Friends)
}