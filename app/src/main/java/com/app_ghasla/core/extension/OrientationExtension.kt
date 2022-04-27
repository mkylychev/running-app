package com.app_ghasla.core.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Canvas
import androidx.fragment.app.Fragment

/**
 * Screen Mode
 */
fun Context.isLandscape(): Boolean {
    return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

fun Fragment.isLandscape() = requireContext().isLandscape()

/**
 * Portrait Mode
 */
@SuppressLint("SourceLockedOrientationActivity")
fun Fragment.setPortraitMode() {
    if (!isLandscape()) return
    requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}

/**
 * Landscape Mode
 */
fun Fragment.setLandscapeMode() {
    if (isLandscape()) return
    requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

fun Fragment.setLandscapeReverseMode() {
    if (isLandscape()) return
    requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
}

/**
 * Orientation: Lock/Unlock
 */
fun Activity.lockOrientation() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
}

fun Activity.unlockOrientation() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
}

/**
 * Canvas
 */
fun Canvas.isLandscape(): Boolean {
    return width > height
}