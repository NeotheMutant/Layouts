package com.example.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appctx
import com.example.database.SchoolDataBase
import com.example.entities.Address
import com.example.entities.Parent
import com.example.entities.Student
import com.example.entities.StudentAndParent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Array

class SchoolViewModel : ViewModel() {
    private val db = SchoolDataBase.getDatabase(appctx)
    private var list = ArrayList<StudentAndParent>()
    var liveList = MutableLiveData<List<StudentAndParent>>()

    fun insert(
        name: String,
        rollNo: String,
        mClass: String,
        addresss: String,
        fName: String,
        mName: String,
        contactNumber: String
    ) {
        val childId = "$mClass$rollNo".toInt()
        viewModelScope.launch(Dispatchers.IO) {
            db.studentDao().insert(

                Student(
                    childId,
                    rollNo.toInt(),
                    mClass.toInt(),
                    name,
                    Address(addresss)
                )
            )

            db.parentDao().insert(Parent(0, childId, fName, mName, contactNumber))
            list.clear()
            list.addAll(db.studentAndParentDao().getStudentAndParent())

        }
        liveList.value = list


    }

    fun getAll(): ArrayList<StudentAndParent> {
        viewModelScope.launch(Dispatchers.IO) {
            list.clear()
            list.addAll(db.studentAndParentDao().getStudentAndParent())
            Log.d("SchoolViewModel", "$list")

        }
        liveList.value = list
        return list
    }


}