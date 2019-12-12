package com.example.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.entities.Parent

@Dao
interface ParentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(parent:Parent)


}