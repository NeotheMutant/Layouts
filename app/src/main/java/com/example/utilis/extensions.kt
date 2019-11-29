package com.example.utilis

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent




fun Context.inflate(layoutRes: Int): View {
    return View.inflate(this, layoutRes,null)
}

fun View.randomColor(): Int {

    var rnd = (1..7).random()

    when (rnd) {
        1 -> return Color.parseColor("#222831")
        2 -> return Color.parseColor("#393e46")
        3 -> return Color.parseColor("#801336")
        4 -> return Color.parseColor("#004445")
        5 -> return Color.parseColor("#621055")
        6 -> return Color.parseColor("#6c1e76")
        7 -> return Color.parseColor("#830263")
    }

    return Color.BLACK
}


fun View.getColor():Int{


    return Color.RED
}


fun Int.giveStatus():String{
    if (this == 0)
        return "OTHERS"
    if (this == 1)
        return "TRAINEE"
    if (this == 2)
        return "MENTORS"

    return "OTHERS"
  }