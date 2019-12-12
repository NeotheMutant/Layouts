package com.example.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey var id: Int,
    var rollNo: Int, var mClass: Int,
    var name: String,
    @Embedded val address: Address
)
 data class Address(var address:String)