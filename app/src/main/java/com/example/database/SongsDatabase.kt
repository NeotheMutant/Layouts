package com.example.database

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dao.SongDao
import com.example.entities.Song

@Database(entities = [Song::class], version = 2, exportSchema = false)
abstract class SongsDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao

    companion object {

        @Volatile
        private var INSTANCE: SongsDatabase? = null

        fun getDatabase(context: Context): SongsDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }



            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        SongsDatabase::class.java,
                        "song"
                    )
                        .fallbackToDestructiveMigration().build()

                INSTANCE = instance

                return instance

            }


        }


    }


}