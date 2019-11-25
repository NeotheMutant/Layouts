package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.acivity_recycler.*

class ContactListActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acivity_recycler)
        val contactList = arrayListOf(
              ContactInfo("Gaurav", "787845548")
            , ContactInfo("Arjun", "787845548")
            , ContactInfo("Ram", "787845548")
            , ContactInfo("Laxman", "787845548")
            , ContactInfo("Ravvan", "787845548")
            , ContactInfo("Hanuman", "787845548")
            , ContactInfo("Tulsi", "787845548")
            , ContactInfo("Nakul", "787845548")
            , ContactInfo("Gaurav", "787845548")
            , ContactInfo("Arjun", "787845548")
            , ContactInfo("Ram", "787845548")
            , ContactInfo("Laxman", "787845548")
            , ContactInfo("Ravvan", "787845548")
            , ContactInfo("Hanuman", "787845548")
            , ContactInfo("Tulsi", "787845548")
            , ContactInfo("Nakul", "787845548")
            , ContactInfo("Gaurav", "787845548")
            , ContactInfo("Arjun", "787845548")
            , ContactInfo("Ram", "787845548")
            , ContactInfo("Laxman", "787845548")
            , ContactInfo("Ravvan", "787845548")
            , ContactInfo("Hanuman", "787845548")
            , ContactInfo("Tulsi", "787845548")
            , ContactInfo("Nakul", "787845548")
            , ContactInfo("Gaurav", "787845548")
            , ContactInfo("Arjun", "787845548")
            , ContactInfo("Ram", "787845548")
            , ContactInfo("Laxman", "787845548")
            , ContactInfo("Ravvan", "787845548")
            , ContactInfo("Hanuman", "787845548")
            , ContactInfo("Tulsi", "787845548")
            , ContactInfo("Nakul", "787845548")
        )



        viewManager = LinearLayoutManager(this)
        viewAdapter =
            ContactAdapter(contactList) { contact: ContactInfo -> contactClicked(contact) }

        MyRecycler.apply {

            layoutManager = viewManager
            adapter = viewAdapter

        }


    }

    fun contactClicked(contact: ContactInfo) {

        val intent = Intent(this, ContactDetailActivity::class.java).apply {

            putExtra("NAME", contact.name)
            putExtra("NUMBER", contact.PhoneNumber)
        }

        startActivity(intent)


    }


}