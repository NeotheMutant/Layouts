package com.example.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.entities.StudentAndParent

@Dao
interface StudentAndParentDao {
    @Transaction
    @Query("SELECT * FROM student")
    fun getStudentAndParent(): List<StudentAndParent>

}