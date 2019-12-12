package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dao.ParentDao
import com.example.dao.StudentAndParentDao
import com.example.dao.StudentDao
import com.example.entities.Parent
import com.example.entities.Student

@Database(entities = arrayOf(Student::class,Parent::class),version = 2,exportSchema = false)
 abstract class SchoolDataBase :RoomDatabase(){

    abstract fun studentDao():StudentDao
    abstract fun parentDao():ParentDao
    abstract  fun studentAndParentDao():StudentAndParentDao

    companion object {

        @Volatile
        private var INSTANCE: SchoolDataBase? = null

        fun getDatabase(context: Context): SchoolDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }



            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        SchoolDataBase::class.java,
                        "School"
                    )
                        .fallbackToDestructiveMigration().build()

                INSTANCE = instance

                return instance

            }


        }


    }
}