package com.app_ghasla.core.extension

import android.os.Build

/**
 * Phone: Model
 */
fun getPhoneModel(): String {
    return "${Build.MANUFACTURER} ${Build.MODEL}"
}

/**
 * SDK
 */
inline fun <T> ifSdk29AndUp(onSdk29: () -> T): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        onSdk29()
    } else null
}