package com.example.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.SettingsFragment

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        supportFragmentManager.beginTransaction().replace(R.id.fragSettings, SettingsFragment())
            .commit()

    }
}