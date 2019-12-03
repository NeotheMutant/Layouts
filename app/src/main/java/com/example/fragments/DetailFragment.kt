package com.example.fragments

import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.layouts.R
import kotlinx.android.synthetic.main.contact_detail_list.*

class DetailFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


    return inflater.inflate(R.layout.contact_detail_list,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvnameDetail.text = getString(R.string.Message)




    }


    fun DisplayDetail(detail:String){
        tvnameDetail.text = detail
    }







}