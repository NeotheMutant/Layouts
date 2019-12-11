package com.example.dao

import androidx.room.*
import com.example.entities.Users

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getALL(): List<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(users: Users)

    @Update
    fun updateUserInfo(users: Users)

    @Delete
    fun deleteUserInfo(users: Users)




}