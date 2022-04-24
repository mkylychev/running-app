package com.app_ghasla.navigation

import com.app_ghasla.navigation.NavCommand

interface NavigationProvider {
    fun launch(navCommand: NavCommand)
}