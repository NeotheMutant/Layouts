package com.example.utilis

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(var a:Int =0) : ViewModel() {

    val notifier = MutableLiveData<Int>()

    fun increment() {

        notifier.value = a++

        }

    fun getNotifierr():MutableLiveData<Int>{

        return notifier
    }

}