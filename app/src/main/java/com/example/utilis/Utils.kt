package com.example.utilis

import android.content.Context
import android.content.Intent
import com.example.layouts.AnimationsActivity
import com.example.layouts.ContactListActivity
import com.example.layouts.ImageFilterActivity
import com.example.layouts.MotionActivity

class Utils {


    companion object Utility{
        fun HandleClick(context:Context,position:Int){

            var intent :Intent = Intent()

            when(position){

                0 -> intent = Intent(context,MotionActivity::class.java)

                1->  intent  = Intent(context,ImageFilterActivity::class.java)

                2-> intent  = Intent(context,ContactListActivity::class.java)

                3-> intent = Intent(context,AnimationsActivity::class.java)



            }

            context.startActivity(intent)

        }


    }



}