package com.app_ghasla.core.extension

import android.content.Intent
import android.net.Uri
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.app_ghasla.R
import com.app_ghasla.navigation.NavCommand
import com.app_ghasla.navigation.NavigationProvider

/**
 * Navigation Controller
 */
fun AppCompatActivity.findNavController(
    @IdRes navHostId: Int = R.id.navHostFragmentMain
) = (supportFragmentManager.findFragmentById(navHostId) as? NavHostFragment)?.navController

fun Fragment.findNavController(
    @IdRes navHostId: Int
) = (parentFragmentManager.findFragmentById(navHostId) as? NavHostFragment)?.navController

fun NavController.currentDestinationId(): Int? = runCatching {
    currentBackStackEntry?.destination?.id
}.getOrNull()

/**
 * NavHost Fragment
 */
fun obtainNavHostFragment(
    fragmentManager: FragmentManager,
    fragmentTag: String,
    navGraph: Int,
    fragmentContainerId: Int
): NavHostFragment {
    // If the NavHost fragment exists, return it
    val existingFragment = fragmentManager.findFragmentByTag(fragmentTag) as NavHostFragment?
    existingFragment?.let { return it }
    // Otherwise, create and return it
    val navHostFragment = NavHostFragment.create(navGraph)
    fragmentManager.beginTransaction()
        .add(fragmentContainerId, navHostFragment, fragmentTag)
        .commitNow()
    return navHostFragment
}

/**
 * Navigation
 */
fun Fragment.navigate(navCommand: NavCommand) {
    (requireActivity() as? NavigationProvider)?.launch(navCommand)
}

/**
 * Back
 */
fun Fragment.back() = runCatching {
    findNavController().popBackStack()
}

/**
 * Close Application
 */
fun Fragment.closeApp() = runCatching {
    requireActivity().finish()
}

/**
 * Google Play
 */
fun Fragment.navigateToGooglePlay() = runCatching {
    startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=${requireActivity().packageName}")
        )
    )
}.onFailure {
    startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com/store/apps/details?id=${requireActivity().packageName}")
        )
    )
}