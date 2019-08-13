package com.example.moviesapp.utils

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    private val projectPrefs = "com.example.moviesapp"
    private val prefs: SharedPreferences = context.getSharedPreferences(projectPrefs, 0)

    fun get() = prefs.getInt("movie_id", 0)

    fun set(value: Int): Boolean {
        return prefs.edit().putInt("movie_id", value).commit()
    }
}