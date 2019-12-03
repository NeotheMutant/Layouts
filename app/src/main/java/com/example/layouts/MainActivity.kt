package com.example.layouts

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.ActivityAdapter
import com.example.utilis.ItemTouchHelperCallBack
import kotlinx.android.synthetic.main.acivity_recycler.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewAdapter: ActivityAdapter? = null
    var activitylist = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         activitylist = arrayListOf<String>(
            "Motion Layout",
            "Image Filter Motion Layout",
            "Recycler View ",
            "Animations | Activity Lifecycle",
            "Fragments",
             "Saving :- Key Value Pairs"
        )






        viewAdapter = ActivityAdapter(activitylist)


        mainRV.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter


        }
        viewAdapter?.let { ItemTouchHelper(ItemTouchHelperCallBack(it)).attachToRecyclerView(mainRV) }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {





                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    viewAdapter?.filter?.filter(newText)


                    return true
                }


            }


            )


        }




        return true
    }

    /*override fun onBackPressed() {
        super.onBackPressed()

        viewAdapter = ActivityAdapter(activitylist)

        mainRV.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter


        }
        viewAdapter?.let { ItemTouchHelper(ItemTouchHelperCallBack(it)).attachToRecyclerView(mainRV) }



    }*/


}
