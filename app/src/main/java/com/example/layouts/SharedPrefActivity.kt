package com.example.layouts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.utilis.randomColor
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_shared_pref.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class SharedPrefActivity : AppCompatActivity() {

    var highScore = 0
    var curScore = 0
    var sharedPref: SharedPreferences? = null
    var i: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        sharedPref = getSharedPreferences(getString(R.string.sharedPrefKey), Context.MODE_PRIVATE)
        tvHighScoreValue.text = sharedPref?.getString(getString(R.string.sharedPrefKey), "-1")
        highScore = tvHighScoreValue.text.toString().toInt()
        val intent = intent



        blinkTV()


        tvBlink.setOnClickListener {

            if (i == 10) {
                setHighScoreG(curScore)
                tvHighScoreValue.text =
                    sharedPref?.getString(getString(R.string.sharedPrefKey), "-1")

                   Snackbar.make(it,"Game Over",Snackbar.LENGTH_INDEFINITE).setAction("Try Again"){
                        finish()

                       startActivity(intent)

                   }.show()


                return@setOnClickListener
            }

            increment()
            tvBlink.text = curScore.toString()

        }


    }


    suspend fun blinkTV() {

        GlobalScope.launch {

            i = 1

            while (i != 10) {

                delay(1000L)
                runOnUiThread {

                    tvSec.text = i.toString()

                }
                i++


            }


        }


    }

    fun increment() {

        curScore += 1

    }

    fun reset() {
        curScore = 0
    }

    fun setHighScoreG(curScore: Int) {


        if (highScore >= curScore) {
            return
        } else {
            highScore = curScore
            sharedPref?.edit().let {

                it?.putString(getString(R.string.sharedPrefKey), highScore.toString())
                it?.apply()
                Log.d("dsdsds", "sdsdsd")
            }


        }

    }

    override fun onStop() {
        super.onStop()
        finish()
    }



}

