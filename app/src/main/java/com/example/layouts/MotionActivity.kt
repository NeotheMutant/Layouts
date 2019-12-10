package com.example.layouts

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MotionActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)




    }






    fun MakeToast(){

        Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show()

    }


}