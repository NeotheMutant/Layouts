package com.example.dao

import androidx.room.*
import com.example.entities.Song
@Dao
interface SongDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSong(song:Song)

    @Update
    fun updateSong(song: Song)

    @Delete
    fun deleteSong(song: Song)

    @Query("SELECT * FROM song")
    fun getALL(): List<Song>

    @Query("DELETE  FROM song")
     fun deALL()

}