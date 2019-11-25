package com.example.layouts

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.contact_detail_list.*

class ContactDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail_list)

        val name = intent.getStringExtra("NAME")
        val phoneNumber = intent.getStringExtra("NUMBER")

        tvnameDetail.text = name
        tvNumber.text = phoneNumber




    }



}