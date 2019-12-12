package com.example.models

import android.database.Cursor
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appctx
import com.example.database.WordDatabase
import com.example.entities.Words
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel :ViewModel(){

    val db = WordDatabase.getDatabase(appctx).wordDao()
   var wordCursor :Cursor? = null
    var cursor = MutableLiveData<Cursor>()


    fun insertWord(word: Words){
        viewModelScope.launch(Dispatchers.IO) {
            db.insertWord(word)
        }

    }

    fun deleteWord(word: Words){
        viewModelScope.launch(Dispatchers.IO) {
            db.deleteWord(word)

        }
    }

    fun deleteAllWord(){
        viewModelScope.launch(Dispatchers.IO) {
            db.deALL()
        }


    }

    fun showWordList():Cursor?{


         viewModelScope.launch(Dispatchers.IO) {
             wordCursor = db.getALL()

         }
        return wordCursor
    }


}