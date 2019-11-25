package com.example.layouts

import android.content.Context
import android.view.View
import android.view.ViewGroup

fun ViewGroup.infalter(layoutRes: Int): View {

    return View.inflate(context, layoutRes, null)
}


fun Context.inflaterr(layoutRes: Int): View {


    return View.inflate(this, layoutRes, null)

}

