package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.motion_activity.*

class MotionActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_activity)




    }






    fun MakeToast(){

        Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()

    }


}