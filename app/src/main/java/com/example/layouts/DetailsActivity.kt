package com.example.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.contact_detail_list.*

class DetailsActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail_list)

        val detail = intent.getStringExtra("DETAIL" )
         tvnameDetail.text = detail




    }

}