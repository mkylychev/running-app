package com.app_ghasla.data.preferences

import android.app.Application

class PreferencesService(
    application: Application
) : PreferencesProvider(application) {

    var isOnBoardingPassed: Boolean by preferences.with(
        IS_ON_BOARDING_PASSED, false
    )

    companion object {
        private const val IS_ON_BOARDING_PASSED = "is_on_boarding_passed"
    }
}