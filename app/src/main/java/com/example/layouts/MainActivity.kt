package com.example.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.ActivityAdapter
import com.example.utilis.ItemTouchHelperCallBack
import kotlinx.android.synthetic.main.acivity_recycler.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var viewManager: RecyclerView.LayoutManager
         val viewAdapter: RecyclerView.Adapter<*>


        val activitylist = arrayListOf<String>(
            "Motion Layout",
            "Image Filter Motion Layout",
            "Recycler View ",
            "Animations | Activity Lifecycle"

        )




        viewManager = LinearLayoutManager(this)
        viewAdapter = ActivityAdapter(activitylist)


        mainRV.apply {

            layoutManager = viewManager
            adapter = viewAdapter



        }
        val itemTouchHelperCallBack = ItemTouchHelperCallBack(viewAdapter)
        val touchHelper = ItemTouchHelper(itemTouchHelperCallBack)
        touchHelper.attachToRecyclerView(mainRV)





    }
}
