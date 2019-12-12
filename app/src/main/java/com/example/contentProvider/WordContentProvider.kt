package com.example.contentProvider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.example.appctx
import com.example.database.WordDatabase
import com.example.entities.Words
import com.example.models.WordViewModel

class WordContentProvider : ContentProvider() {

    lateinit var model: WordViewModel

    private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    private fun intilizeUrimatching() {
        sUriMatcher.addURI(AUTHORITY, PATH, 1)
        sUriMatcher.addURI(AUTHORITY, "$PATH#", 2)

    }

    override fun insert(p0: Uri, values: ContentValues?): Uri? {

        val data = values?.getAsString("word").toString()

        model.insertWord(Words(0,data))

        return CONTENT_URI
    }

    override fun query(
        p0: Uri,
        p1: Array<String>?,
        p2: String?,
        p3: Array<String>?,
        p4: String?
    ): Cursor? {


        when (1) {

            GET_ALL -> {
                return model.showWordList()
            }

            DEL_ALL ->{
                model.deleteAllWord()
            }
        }

        return null
    }

    override fun onCreate(): Boolean {

        intilizeUrimatching()
        model = WordViewModel()
        Log.d("WordContentProvider","onCreate")
        return true
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<String>?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<String>?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(p0: Uri): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val AUTHORITY = "com.example.layouts.provider"
        val CONTENT_URI = Uri.parse("content://$AUTHORITY")
        const val _ID = "id"
        const val WORD ="word"
        const val GET_ALL = 1
        const val DEL_ALL = 2
        const val PATH = "new"
    }


}



