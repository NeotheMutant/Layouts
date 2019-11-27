package com.example.layouts

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ScResultActivity : Activity(){

    val TAG = "ScResultActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sc_result)
        Log.d(TAG,"Created")


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }


    private fun handleIntent(){

        if (Intent.ACTION_SEARCH == intent.action){
         val query = intent.getStringExtra(SearchManager.QUERY)
        }

    }




}