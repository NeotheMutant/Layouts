package com.example.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.models.MyViewModel
import kotlinx.android.synthetic.main.activity_test_viewmodel.*

class TestViewModel : AppCompatActivity() {

     private val changeObserver = Observer<Int> {
        tvTest.text = it.toString()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_viewmodel)

         val model: MyViewModel = ViewModelProviders.of(this)[MyViewModel::class.java]


        model.notifier.observe(this,changeObserver)


        tvTest.setOnClickListener {

            model.increment()
        }


    }

}