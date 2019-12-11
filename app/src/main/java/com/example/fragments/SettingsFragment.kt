package com.example.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.layouts.R

class SettingsFragment :PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings,rootKey)
    }

}