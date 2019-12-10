package com.example.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL

@Entity
data class Song(@PrimaryKey(autoGenerate = true) val songId:Int, var songName:String, var url: String )