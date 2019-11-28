package com.example.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adapters.ContactAdapter
import kotlinx.android.synthetic.main.contact_detail_list.*

class ContactDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail_list)

        val name = intent.getStringExtra(ContactAdapter.NAME)
        val phoneNumber = intent.getStringExtra(ContactAdapter.NUMBER)

        tvnameDetail.text = name
        tvNumber.text = phoneNumber




    }



}