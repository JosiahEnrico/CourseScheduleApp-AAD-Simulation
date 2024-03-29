package com.aadexercise.courseschedule

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.aadexercise.courseschedule.util.NightMode
import java.util.*

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.getString(
            getString(R.string.pref_key_dark),
            getString(R.string.pref_dark_auto)
        )?.apply {
            val mode = NightMode.valueOf(this.toUpperCase(Locale.US))
            AppCompatDelegate.setDefaultNightMode(mode.value)
        }
    }
}