package com.example.dao

import android.database.Cursor
import androidx.room.*
import com.example.entities.Words

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: Words)

    @Update
    fun updateWord(word: Words)

    @Delete
    fun deleteWord(word: Words)

    @Query("SELECT * FROM words")
    fun getALL():Cursor

    @Query("DELETE FROM words")
    fun deALL()



}