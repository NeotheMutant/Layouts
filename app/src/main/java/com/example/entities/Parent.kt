package com.example.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Parent(
    @PrimaryKey(autoGenerate = true) var parentId: Int,
    var childId: Int,
    var fatherName: String,
    var mothersName: String,
    var contactNumber:String

)