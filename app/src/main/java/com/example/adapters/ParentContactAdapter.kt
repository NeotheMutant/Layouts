package com.example.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.R
import com.example.models.ContactInfo
import com.example.utilis.giveStatus
import com.example.utilis.infalter
import kotlinx.android.synthetic.main.activity_parent_rv.view.*

class ParentContactAdapter(private val contactList: ArrayList<ContactInfo>) :
    RecyclerView.Adapter<ParentContactAdapter.ViewHolder>() {

    private val recyclePool = RecyclerView.RecycledViewPool()
    val set = mutableSetOf<Int>()



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val recyclerView: RecyclerView = itemView.rvChild

        fun setTextView(post: String) {
            itemView.tvParentRv.text = post

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(parent.infalter(R.layout.activity_parent_rv))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = contactList[position].post


        if (set.add(post)) {
            val filteredList = contactList.filter { it.post == post }

            holder.setTextView(post.giveStatus())

            val childLayout = LinearLayoutManager(holder.recyclerView.context)

            holder.recyclerView.apply {

                layoutManager = childLayout
                adapter = ContactAdapter(filteredList)
                setRecycledViewPool(recyclePool)


            }
        }





    }


    override fun getItemCount() = contactList.size


}
