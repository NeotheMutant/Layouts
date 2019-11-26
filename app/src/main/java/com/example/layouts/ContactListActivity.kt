package com.example.layouts

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.acivity_recycler.*

class ContactListActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    val HAS_IMAGE = 1
    val NO_IMAGE = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_recycler)
        val contactList = arrayListOf(
            ContactInfo("Gaurav", "4454545455", HAS_IMAGE, R.drawable.ic_perm_identity_black_24dp),
            ContactInfo("Nakul", "987745458")
        )



        viewManager = LinearLayoutManager(this)

        viewAdapter = ContactAdapter(contactList)

        MyRecycler.apply {

            layoutManager = viewManager
            adapter = viewAdapter

        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }


}
