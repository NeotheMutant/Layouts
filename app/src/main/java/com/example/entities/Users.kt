package com.example.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(@PrimaryKey(autoGenerate = true) val id:Int,val name:String, val quotes :String)