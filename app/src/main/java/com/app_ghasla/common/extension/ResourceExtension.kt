package com.app_ghasla.common.extension

import android.graphics.Typeface
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.FontRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

/**
 * Color
 */
fun View.getColor(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(context, colorRes)
}

fun Fragment.getColor(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(requireContext(), colorRes)
}

/**
 * Font
 */
fun Fragment.getFont(@FontRes fontRes: Int): Typeface? {
    return ResourcesCompat.getFont(requireContext(), fontRes)
}