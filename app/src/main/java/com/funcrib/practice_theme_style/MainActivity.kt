package com.funcrib.practice_theme_style

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)

        val appSettingsPreferences: SharedPreferences =
            getSharedPreferences("AppSettingsPreferences", 0)
        val sharedPreferencesEdit: SharedPreferences.Editor = appSettingsPreferences.edit()
        val isNightModeOn: Boolean = appSettingsPreferences.getBoolean("Night Mode", false)

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            button.text = "Disable Night Mode"
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            button.text = "Enable Dark Mode"
        }

        button.setOnClickListener {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferencesEdit.putBoolean("Night Mode", false)
                sharedPreferencesEdit.apply()
                button.text = "Enable Night Mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferencesEdit.putBoolean("Night Mode", true)
                sharedPreferencesEdit.apply()
                button.text = "Disable Dark Mode"
            }
        }
    }
}