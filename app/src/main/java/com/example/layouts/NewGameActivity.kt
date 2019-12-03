package com.example.layouts

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_game.*

class NewGameActivity :AppCompatActivity(), DialogInterface{
    override fun dismiss() {

    }

    override fun cancel() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_game)

        btnTryAgain.setOnClickListener {
            val intent = Intent(this,SharedPrefActivity::class.java)
            startActivity(intent)
           finish()
        }



    }

}

