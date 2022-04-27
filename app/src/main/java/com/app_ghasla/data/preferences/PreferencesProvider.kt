package com.app_ghasla.data.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

abstract class PreferencesProvider(
    private val application: Application
) {
    protected val preferences: SharedPreferences by lazy {
        getSharedPreferences()
    }

    private fun getSharedPreferences(): SharedPreferences {
        return application.getSharedPreferences(
            PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun clear() = preferences.edit().clear().apply()

    companion object {
        private const val PREFERENCES_NAME = "app_preferences"
    }
}