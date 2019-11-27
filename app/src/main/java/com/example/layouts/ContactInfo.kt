package com.example.layouts

import androidx.annotation.DrawableRes

data class ContactInfo (var name:String, var phoneNumber:String, var hasImage:Int=0, @DrawableRes var ImgId:Int? =null, var post : Int =0 )
