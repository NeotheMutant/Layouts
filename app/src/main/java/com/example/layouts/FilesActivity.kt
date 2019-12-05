package com.example.layouts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.utilis.LifecycleListener
import kotlinx.android.synthetic.main.activity_files.*
import java.io.File
import java.lang.StringBuilder
import java.util.*

class FilesActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var test: LifecycleListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_files)

        /*lifecycle.addObserver(LifecycleListener {Toast.makeText(this,it,Toast.LENGTH_SHORT).show()})*/

        btnClick.setOnClickListener {
            takePicture()
        }

    }

    private fun takePicture() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { picIntent ->
            picIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(picIntent, REQUEST_IMAGE_CAPTURE)

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val image = data?.extras?.get("data") as Bitmap
            ivCamera.setImageBitmap(image)
        }

    }


}