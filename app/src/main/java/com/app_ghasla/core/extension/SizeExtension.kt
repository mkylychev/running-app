package com.app_ghasla.core.extension

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

/**
 * Convert dp to px
 */
fun Int.dpToPx(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        toFloat(),
        context.resources.displayMetrics
    ).toInt()
}

/**
 * Convert dimen resource to px
 */
fun Int.dpToPx(resources: Resources) = runCatching {
    resources.getDimensionPixelSize(this)
}.getOrDefault(0)

/**
 * Convert sp to px
 */
fun Int.spToPx(context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        toFloat(),
        context.resources.displayMetrics
    ).toInt()
}