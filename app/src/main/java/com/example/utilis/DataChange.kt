package com.example.utilis

import com.example.entities.Song

interface DataChange<T>{
    fun dataSetChange(list: List<T>)

}