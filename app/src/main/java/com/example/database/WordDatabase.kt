package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dao.SongDao
import com.example.dao.WordDao
import com.example.entities.Song
import com.example.entities.Words

@Database(entities = [Words::class], version = 2, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getDatabase(context: Context): WordDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }



            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        WordDatabase::class.java,
                        "word"
                    )
                        .fallbackToDestructiveMigration().build()

                INSTANCE = instance

                return instance

            }


        }


    }


}