package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.GenAdapter
import com.example.layouts.FragmentsActivity
import com.example.layouts.R
import com.example.models.AuthorsAndQuotes
import com.example.utilis.randomColor
import kotlinx.android.synthetic.main.contact_view.view.*
import kotlinx.android.synthetic.main.activity_activity.*

class TitlesFragments : Fragment() {

    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var viewAdapter: RecyclerView.Adapter<*>
    var dualPane = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_activity, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            AuthorsAndQuotes("Gaurav", "Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
            AuthorsAndQuotes(
                "Vishak",
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae "
            )
            , AuthorsAndQuotes("Sridhar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")

        )


        viewManager = LinearLayoutManager(context)
        viewAdapter =
            GenAdapter(
                list, { TitlesViewHolder(it) }, R.layout.contact_view
            )
            { position, holder ->
                holder.itemView.tvName.text = list[position].name
                holder.itemView.tvFirstWord.text = list[position].name.firstOrNull().toString()
                holder.itemView.tvFirstWord.background.setTint(view.randomColor())

                holder.itemView.setOnClickListener {

                    val mycom = context as FragmentsActivity
                    mycom.DisplayDetails(list[position].qoutes)
                }

            }
        rvTitles.apply {

            layoutManager = viewManager

            adapter = viewAdapter

        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val detailFram = activity?.findViewById<View>(R.id.flDetails)

        dualPane = detailFram?.visibility == View.VISIBLE

        Log.d("Titles Activity", "$dualPane")

    }

    inner class TitlesViewHolder(view: View) : RecyclerView.ViewHolder(view)


}









