package com.example.layouts

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_info_view.view.*
import java.util.ArrayList

class Adapter(private val dataSet: ArrayList<EmployInfo>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(eInfo: EmployInfo) {

            view.tvName.text = eInfo.name
            view.tvAge.text = eInfo.age
            view.tvPost.text = eInfo.post

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {

        val linearLayout = parent.infalter(R.layout.person_info_view)
        return ViewHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(dataSet[position])

    }

    override fun getItemCount() = dataSet.size


    fun ViewGroup.infalter(layoutRes: Int): View {

        return View.inflate(context, layoutRes, null)
    }


    fun Context.inflaterr(layoutRes: Int): View {


        return View.inflate(this, layoutRes, null)

    }


}




