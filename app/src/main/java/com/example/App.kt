package com.example

import android.app.Application



lateinit var appctx:Application

class App :Application() {
    init {
        appctx = this
    }


    override fun onCreate() {
        super.onCreate()
        appctx = this

    }





}