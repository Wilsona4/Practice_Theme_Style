package com.funcrib.practice_theme_style

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val switch: Switch = findViewById(R.id.bt_switch)

        val appSettingsPreferences: SharedPreferences =
            getSharedPreferences("AppSettingsPreferences", 0)
        val sharedPreferencesEdit: SharedPreferences.Editor = appSettingsPreferences.edit()
        val isNightModeOn: Boolean = appSettingsPreferences.getBoolean("Night Mode", false)

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            button.text = R.string.disable_dark_mode.toString()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            button.text = R.string.enable_dark_mode.toString()
        }

        button.setOnClickListener {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferencesEdit.putBoolean("Night Mode", false)
                sharedPreferencesEdit.apply()
                button.text = R.string.enable_dark_mode.toString()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferencesEdit.putBoolean("Night Mode", true)
                sharedPreferencesEdit.apply()
                button.text = R.string.disable_dark_mode.toString()
            }
        }

        switch.setOnCheckedChangeListener { _, isChecked ->
            button.isEnabled = isChecked
        }
    }
}