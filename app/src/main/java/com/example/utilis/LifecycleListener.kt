package com.example.utilis

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.layouts.FilesActivity

class LifecycleListener(var toast:(String) ->Unit) : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateListner() {
        Log.d("LIFECYCLELISTENER", "ONCREATE INVOKED")
        toast("onCreate")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseListner() {
        Log.d("LIFECYCLELISTENER", "ONPAUSE INVOKED")
        toast("On pause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeListner() {
        Log.d("LIFECYCLELISTENER", "ONRESUME INVOKED")
        toast("On Resume")

    }



}