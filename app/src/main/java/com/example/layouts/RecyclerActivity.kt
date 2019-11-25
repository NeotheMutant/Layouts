package com.example.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.acivity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_recycler)


        val array = arrayListOf<EmployInfo>()

        array.add(EmployInfo("gaurav", "23", "Traineee"))
        array.add(EmployInfo("A", "23", "Traineee"))
        array.add(EmployInfo("B", "23", "Traineee"))
        array.add(EmployInfo("C", "23", "Traineee"))
        array.add(EmployInfo("D", "23", "Traineee"))
        array.add(EmployInfo("E", "23", "Traineee"))
        array.add(EmployInfo("gaurav", "23", "Traineee"))
        array.add(EmployInfo("A", "23", "Traineee"))
        array.add(EmployInfo("B", "23", "Traineee"))
        array.add(EmployInfo("C", "23", "Traineee"))
        array.add(EmployInfo("D", "23", "Traineee"))
        array.add(EmployInfo("E", "23", "Traineee"))


        viewManager = LinearLayoutManager(this)
        viewAdapter = Adapter(array)


        MyRecycler.apply {

            layoutManager = viewManager

            adapter = viewAdapter

        }

    }
}