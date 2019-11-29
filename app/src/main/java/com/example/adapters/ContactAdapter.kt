package com.example.adapters

import android.content.Intent

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.ContactDetailActivity
import com.example.layouts.ContactListActivity
import com.example.layouts.R
import com.example.models.ContactInfo
import com.example.utilis.inflate
import com.example.utilis.randomColor
import kotlinx.android.synthetic.main.contact_view.view.*
import kotlinx.android.synthetic.main.contact_view.view.tvName

class ContactAdapter(private val contactList: ArrayList<ContactInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


       return ViewHolder(parent.context.inflate(R.layout.contact_view))

    }

    override fun getItemCount() = contactList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ViewHolder)
        holder.onBind(contactList[position])


    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(contactInfo: ContactInfo) {

            with(itemView) {


                tvName.text = contactInfo.name


                if (contactInfo.hasImage == ContactListActivity.NO_IMAGE) {
                    tvFirstWord.text = contactInfo.name.firstOrNull().toString()
                    tvFirstWord.background.setTint(randomColor())
                    imContactImage.visibility = View.INVISIBLE
                } else {
                    contactInfo.ImgId?.let { imContactImage.setImageResource(it) }
                    imContactImage.background?.setTint(randomColor())
                    tvFirstWord.visibility = View.INVISIBLE

                }


                itemView.setOnClickListener {

                    Intent(context, ContactDetailActivity::class.java).apply {
                        putExtra(NAME, contactInfo.name)
                        putExtra(NUMBER, contactInfo.phoneNumber)
                        context.startActivity(this)

                    }


                }


            }


        }


    }


    companion object Details {
        const val NAME = "NAME"
        const val NUMBER = "NUMBER"
    }
}


