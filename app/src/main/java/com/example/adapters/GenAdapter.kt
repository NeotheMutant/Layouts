package com.example.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layouts.R
import com.example.utilis.inflate
import java.util.zip.Inflater

class GenAdapter<T, V : RecyclerView.ViewHolder>(
    var list: List<T>,
    private var vh: (View) -> V,
    private var layoutRes: Int,
    private var vhBinder: (Int, V) -> Unit
) : RecyclerView.Adapter<V>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {


        return vh(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: V, position: Int) {

        vhBinder(position, holder)

    }


}