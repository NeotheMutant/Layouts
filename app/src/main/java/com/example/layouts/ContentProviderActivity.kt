package com.example.layouts

import android.content.ContentUris
import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.provider.UserDictionary
import android.util.Log
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.contentProvider.WordContentProvider
import kotlinx.android.synthetic.main.activity_content_provider.*

class ContentProviderActivity : AppCompatActivity() {

    private val mProjection = arrayOf(

        WordContentProvider._ID,
        WordContentProvider.WORD,
        WordContentProvider.PATH
    )

    private var selectionClause: String? = null
    private lateinit var selectionArgs: Array<String>
    private var searchString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        val getAllUri =
            Uri.parse("content://${WordContentProvider.AUTHORITY}/${WordContentProvider.PATH}")
        val uri = ContentUris.withAppendedId(getAllUri, 1)

        val mCursor = contentResolver.query(
            uri,
            mProjection,
            null,
            null,
            null
        )
        Log.d("old cursor","${mCursor?.count}")

        val cursorAdapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_list_item_1,
            mCursor,
            arrayOf(WordContentProvider.WORD),
            intArrayOf(android.R.id.text1),
            0
        )
        lvWords.adapter = cursorAdapter

        btnSearch.setOnClickListener {

            val contentValues = ContentValues().apply {
                Log.d("value put", "value =${etSearch.text.toString()}")
                put("word", etSearch.text.toString())
            }

            contentResolver.insert(WordContentProvider.CONTENT_URI, contentValues)

            val changeCursor = contentResolver.query(
                    uri,
            mProjection,
            null,
            null,
            null
            )
            Log.d("new cursor","${changeCursor?.count}")


            cursorAdapter.changeCursor(changeCursor)

        }


    }


}