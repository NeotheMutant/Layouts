package com.example.entities

import androidx.room.Embedded
import androidx.room.Relation

data class StudentAndParent(
    @Embedded var student: Student, @Relation(
        parentColumn = "id",
        entityColumn = "childId"
    ) val parent: Parent
)