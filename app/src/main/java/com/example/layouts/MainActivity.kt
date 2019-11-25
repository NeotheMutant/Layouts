package com.example.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOne.setOnClickListener {
            val intent = Intent(this,MotionActivity::class.java)
            startActivity(intent)


        }

        btnTwo.setOnClickListener {
            val intent = Intent(this,ImageFilterActivity::class.java)
            startActivity(intent)

        }



        btnFour.setOnClickListener {
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }


        btnFive.setOnClickListener {
            val intent = Intent(this,ContactListActivity::class.java)
            startActivity(intent)

        }


    }
}
