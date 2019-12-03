package com.example.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.R
import com.example.utilis.*
import kotlinx.android.synthetic.main.contact_view.view.*
import java.util.*
import kotlin.collections.ArrayList


class ActivityAdapter(private val activityList: ArrayList<String>) :
    RecyclerView.Adapter<ActivityAdapter.ViewHolder>(),
    ItemTouchHelperCallBack.ItemTouchHelperAdapter, Filterable {

    lateinit var filteredList: ArrayList<String>


    override fun getFilter() = SearchFilter()

    override fun onItemMoved(fromPosition: Int, toPosition: Int) =
        swapItems(fromPosition, toPosition)

    override fun onItemDismiss(position: Int, direction: Int, viewHolder: RecyclerView.ViewHolder) =
        swipeItem(position, direction, viewHolder)

    lateinit var context: Context


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.contact_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = activityList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.tvName.text = activityList[position]
        holder.itemView.tvFirstWord.text = activityList[position].firstOrNull().toString()
        with(holder.itemView) {
            tvFirstWord.background.setTint(randomColor())
        }



        holder.itemView.setOnClickListener {

            context = holder.itemView.context

            Utils.HandleClick(context, position)
        }
    }


    private fun swapItems(fromPosition: Int, toPosition: Int) {
        Collections.swap(activityList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    private fun swipeItem(position: Int, direction: Int, viewHolder: RecyclerView.ViewHolder) {

        if (direction == ItemTouchHelper.END) {
            activityList.removeAt(position)
            notifyItemRemoved(position)
        }

        if (direction == ItemTouchHelper.START) {
            context = viewHolder.itemView.context
            Utils.HandleClick(context, position)
            notifyItemChanged(position)

        }


    }


    inner class SearchFilter : Filter() {


        override fun performFiltering(constraint: CharSequence?): FilterResults {

            val filterResults = FilterResults()
            filteredList = ArrayList<String>()




            constraint?.let {

                if (it.isNotEmpty()) {

                    for (s in activityList) {

                        if (s.startsWith(it.toString())) {
                            filteredList.add(s)
                        }
                    }

                    filterResults.count = filteredList.size
                    filterResults.values = filteredList


                } else {
                    filterResults.count = activityList.size
                    filterResults.values = activityList
                }

            }

            return filterResults

        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {




            if (!constraint.isNullOrBlank()) {
                activityList.clear()
                activityList.addAll(results?.values as ArrayList<String>)

            }

            notifyDataSetChanged()

        }


    }




}




