package com.aadexercise.courseschedule.ui.setting

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.aadexercise.courseschedule.R
import com.aadexercise.courseschedule.notification.DailyReminder
import com.aadexercise.courseschedule.util.NightMode
import java.util.*

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        //TODO 10 : Update theme based on value in ListPreference
        val preferenceTheme =  findPreference<ListPreference>(getString(R.string.pref_key_dark))
        preferenceTheme?.setOnPreferenceChangeListener { _, newValue ->
            val mode = NightMode.valueOf(newValue.toString().toUpperCase(Locale.US))
            updateTheme(mode.value)
            Toast.makeText(requireContext(), "theme changed", Toast.LENGTH_SHORT).show()
            true
        }
        //TODO 11 : Schedule and cancel notification in DailyReminder based on SwitchPreference

        val prefNotification = findPreference<SwitchPreference>("key_notification")
        val dailyReminder = DailyReminder()
        prefNotification?.setOnPreferenceChangeListener{_, newValue ->
            val checkValue = newValue as Boolean

            if (checkValue) {
                dailyReminder.setDailyReminder(requireContext())
            } else{
                dailyReminder.cancelAlarm(requireContext())
            }
            true
        }
    }

    private fun updateTheme(nightMode: Int): Boolean {
        AppCompatDelegate.setDefaultNightMode(nightMode)
        requireActivity().recreate()
        return true
    }
}