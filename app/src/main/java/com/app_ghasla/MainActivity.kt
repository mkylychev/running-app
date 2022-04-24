package com.app_ghasla

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.app_ghasla.databinding.ActivityMainBinding
import com.app_ghasla.navigation.NavCommand
import com.app_ghasla.navigation.NavCommands
import com.app_ghasla.navigation.NavigationProvider
import com.app_ghasla.ui.base.activity.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationProvider {

    private val navController: NavController?
        get() = findNavController(R.id.navHostFragmentMain)

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    /**
     * Navigation
     */
    override fun launch(navCommand: NavCommand) {
        when (val target = navCommand.target) {
            is NavCommands.Id -> openScreenById(
                id = target.id,
                isModal = target.isModal,
                isSingleTop = target.isSingleTop,
                bundle = navCommand.args
            )
            is NavCommands.DeepLink -> openScreenByDeepLink(
                url = target.link.toUri(),
                isModal = target.isModal,
                isSingleTop = target.isSingleTop
            )
        }
    }

    private fun openScreenById(
        @IdRes id: Int,
        bundle: Bundle? = null,
        isModal: Boolean = false,
        isSingleTop: Boolean
    ) {
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.fade_in)
            .setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in)
            .setPopExitAnim(R.anim.fade_out)
            .setPopUpTo(
                destinationId = if (isSingleTop) R.id.graph_main else -1,
                inclusive = isSingleTop
            )
            .setLaunchSingleTop(isSingleTop)
            .build()
        navController?.navigate(id, bundle, navOptions)
    }

    private fun openScreenByDeepLink(
        url: Uri,
        isModal: Boolean = false,
        isSingleTop: Boolean
    ) {
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.fade_in)
            .setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in)
            .setPopExitAnim(R.anim.fade_out)
            .setPopUpTo(
                destinationId = if (isSingleTop) R.id.graph_main else -1,
                inclusive = isSingleTop
            )
            .setLaunchSingleTop(isSingleTop)
            .build()
        navController?.navigate(url, navOptions)
    }
}