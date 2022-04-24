package com.app_ghasla.navigation

import androidx.annotation.IdRes

sealed class NavCommands {

    data class Id(
        @IdRes val id: Int,
        val isModal: Boolean = false,
        val isSingleTop: Boolean = false
    ) : NavCommands()

    data class DeepLink(
        val link: String,
        val isModal: Boolean = false,
        val isSingleTop: Boolean = false
    ) : NavCommands()

    data class Browser(val url: String) : NavCommands()
}