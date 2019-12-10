package com.example.layouts

import android.animation.LayoutTransition
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        clAnimation.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

         var flag = true

        btnAnima.setOnLongClickListener{


           if (flag) {
               btnAnima.text = getString(R.string.Long_Text)
               flag = false
           }else
           {
               btnAnima.text = getString(R.string.press)
               flag = true

           }





            true

        }


    }



    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show()


    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show()


    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show()


    }







}