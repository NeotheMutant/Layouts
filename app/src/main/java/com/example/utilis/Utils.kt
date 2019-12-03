package com.example.utilis

import android.content.Context
import android.content.Intent
import com.example.layouts.*

class Utils {


    companion object Utility{
        fun HandleClick(context:Context,position:Int){

            var intent :Intent = Intent()

            when(position){

                0 -> intent = Intent(context,MotionActivity::class.java)

                1->  intent  = Intent(context,ImageFilterActivity::class.java)

                2-> intent  = Intent(context,ContactListActivity::class.java)

                3-> intent = Intent(context,AnimationsActivity::class.java)

                4-> intent = Intent(context,FragmentsActivity::class.java)

                5-> intent = Intent(context,SharedPrefActivity::class.java)



            }

            context.startActivity(intent)

        }


    }



}