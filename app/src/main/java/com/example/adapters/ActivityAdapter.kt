package com.example.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.R
import com.example.layouts.infalter
import com.example.layouts.randomColor
import com.example.models.ActivityInfo
import com.example.models.Utils
import kotlinx.android.synthetic.main.contact_view.view.*

class ActivityAdapter(private val activityList: ArrayList<String>) :
    RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    lateinit var context :Context


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(parent.infalter(R.layout.contact_view))
    }

    override fun getItemCount() = activityList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.tvName.text = activityList[position]
        holder.itemView.tvFirstWord.text = activityList[position].firstOrNull().toString()
        with(holder.itemView){
            tvFirstWord.background.setTint(randomColor())
        }



        holder.itemView.setOnClickListener {

            context = holder.itemView.context

            Utils.HandleClick(context,position)
        }
    }

}