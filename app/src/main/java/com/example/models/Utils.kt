package com.example.models

import android.content.Context
import android.content.Intent
import com.example.layouts.ContactListActivity
import com.example.layouts.ImageFilterActivity
import com.example.layouts.MotionActivity
import java.text.FieldPosition

class Utils {


    companion object Utility{
        fun HandleClick(context:Context,position:Int){

            var intent :Intent = Intent()

            when(position){

                0 -> intent = Intent(context,MotionActivity::class.java)

                1->  intent  = Intent(context,ImageFilterActivity::class.java)

                2-> intent  = Intent(context,ContactListActivity::class.java)



            }

            context.startActivity(intent)

        }


    }



}