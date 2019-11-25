package com.example.layouts

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_view.view.*

class ContactAdapter(private val contactList: ArrayList<ContactInfo>,val clickListener : (ContactInfo)-> Unit) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(parent.infalter(R.layout.contact_view))
    }

    override fun getItemCount() = contactList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(contactList[position],clickListener)

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(contactInfo: ContactInfo,clickListener: (ContactInfo) -> Unit) {

            with(itemView) {
                tvName.text = contactInfo.name
                tvFirstWord.text = contactInfo.name.firstOrNull().toString()
                tvFirstWord.background.setTint(randomColor())
                itemView.setOnClickListener {
                    clickListener(contactInfo)
                }


            }


        }


        fun randomColor(): Int {

            var rnd = (1..7).random()

            when (rnd) {
                1 -> return Color.parseColor("#222831")
                2 -> return Color.parseColor("#393e46")
                3 -> return Color.parseColor("#801336")
                4 -> return Color.parseColor("#004445")
                5 -> return Color.parseColor("#621055")
                6 -> return Color.parseColor("#6c1e76")
                7 -> return Color.parseColor("#830263")
            }

            return Color.BLACK
        }


    }


}
