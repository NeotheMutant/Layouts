package com.example.layouts

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.ParentContactAdapter
import com.example.models.ContactInfo
import kotlinx.android.synthetic.main.acivity_recycler.*
import kotlinx.android.synthetic.main.activity_nestedrv.*

class ContactListActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nestedrv)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val contactList = arrayListOf(
            ContactInfo(
                "Gaurav",
                "4454545455",
                HAS_IMAGE,
                R.drawable.ic_perm_identity_black_24dp,
                TRAINEE
            ),
            ContactInfo("Nakul", "987745458", post = MENTORS),
            ContactInfo("Arjun", "987745458", post = OTHERS),
            ContactInfo("Sahdev", "987745458", post = OTHERS),
            ContactInfo("Arjun", "987745458", post = OTHERS),
            ContactInfo("Sahdev", "987745458", post = OTHERS)

        )



        viewManager = LinearLayoutManager(this)

        viewAdapter = ParentContactAdapter(contactList)

        rvParent.apply {

            layoutManager = viewManager
            adapter = viewAdapter

        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

       val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        (menu.findItem(R.id.search).actionView as SearchView ).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }




        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {






        return super.onOptionsItemSelected(item)
    }




   companion object status{
       const val TRAINEE = 1
       const val MENTORS = 2
       const val OTHERS  = 0
       const val HAS_IMAGE = 1
       const val NO_IMAGE = 0

   }

}
