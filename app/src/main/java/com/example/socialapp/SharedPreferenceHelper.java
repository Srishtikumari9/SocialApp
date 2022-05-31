package com.example.socialapp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;


public class SharedPreferenceHelper {
    public static void setString(Context context, String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, defValue);
    }

}

