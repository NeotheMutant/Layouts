package com.example.layouts

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
        val contactList = ArrayList<ContactInfo>()
        contactList.add(ContactInfo("Gaurav", "787845548"))
        contactList.add(ContactInfo("Arjun", "787845548"))
        contactList.add(ContactInfo("Ram", "787845548"))
        contactList.add(ContactInfo("Laxman", "787845548"))
        contactList.add(ContactInfo("Ravvan", "787845548"))
        contactList.add(ContactInfo("Hanuman", "787845548"))
        contactList.add(ContactInfo("Tulsi", "787845548"))
        contactList.add(ContactInfo("Nakul", "787845548"))



        viewManager = LinearLayoutManager(this)
        viewAdapter = ContactAdapter(contactList) { contact:ContactInfo -> contactClicked(contact)}

        MyRecycler.apply {

            layoutManager = viewManager
            adapter = viewAdapter

        }


    }

    fun contactClicked(contact:ContactInfo){

        Toast.makeText(this,"${contact.name} clicked",Toast.LENGTH_SHORT).show()

    }





}