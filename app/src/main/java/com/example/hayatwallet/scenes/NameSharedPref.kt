package com.example.hayatwallet.scenes

import android.content.Context
import android.content.SharedPreferences

object NameSharedPref {
    private const val PREFERENCES_NAME = "user_prefs"
    private var sharedPreferences: SharedPreferences? = null

    // Initialize SharedPreferences
    fun init(context: Context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        }
    }

    // Save a string value to SharedPreferences
    fun putString(key: String, value: String?) {
        sharedPreferences?.edit()?.putString(key, value)?.apply()
    }

    // Retrieve a string value from SharedPreferences
    fun getString(key: String, defaultValue: String? = null): String? {
        return sharedPreferences?.getString(key, defaultValue)
    }

    // Save a boolean value to SharedPreferences
    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences?.edit()?.putBoolean(key, value)?.apply()
    }

    // Retrieve a boolean value from SharedPreferences
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences?.getBoolean(key, defaultValue) ?: defaultValue
    }

    // Clear all values in SharedPreferences
    fun clear() {
        sharedPreferences?.edit()?.clear()?.apply()
    }
}
