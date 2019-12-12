package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.entities.StudentAndParent
import com.example.models.SchoolViewModel
import kotlinx.android.synthetic.main.activity_school_info.*

class SchoolInfoActivity : AppCompatActivity() {

    val list = ArrayList<StudentAndParent>()

    val changeObserver = Observer<List<StudentAndParent>> {
        list.addAll(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_info)
        var model: SchoolViewModel = SchoolViewModel()

        model.liveList.observe(this, changeObserver)


        Log.d("SchoolInfoActivity", "${model.getAll()}")


        btnStudentInfoSubmit.setOnClickListener {
            model.insert(
                etStudentName.text.toString(),
                etRollNo.text.toString(),
                etClass.text.toString(),
                etAddress.text.toString(),
                etFathersName.text.toString(),
                etMothersName.text.toString(),
                etContactInfo.text.toString()
            )
           finish()
        }


    }

}