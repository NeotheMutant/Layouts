package com.example.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dao.UserDao
import com.example.entities.Users

@Database(entities = arrayOf(Users::class), version = 3,exportSchema = false)
 abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        fun getDatabase(context: Context): UserDatabase {

            val db = Room.databaseBuilder(context, UserDatabase::class.java, "UserInfoDb").fallbackToDestructiveMigration().build()
            return db
        }


    }



}

