package com.example.roomhomeworkdefaultrepo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Friends::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun friendDao(): FriendsDao

    companion object {
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase? {
            instance = Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "friends-table"
            ).build()
            return instance
        }
    }
}