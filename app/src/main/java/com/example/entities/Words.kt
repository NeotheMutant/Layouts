package com.example.entities

import android.provider.BaseColumns
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Words(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = BaseColumns._ID) var _id:Int, var word:String)