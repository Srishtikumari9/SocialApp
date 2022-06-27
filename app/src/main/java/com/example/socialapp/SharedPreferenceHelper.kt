package com.example.socialapp

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPreferenceHelper {
    fun setString(context: Context, key: String, value: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(
            context
        )
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getString(context: Context, key: String, defValue: String): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(
            context
        )
        return preferences.getString(key, defValue)
    }
}