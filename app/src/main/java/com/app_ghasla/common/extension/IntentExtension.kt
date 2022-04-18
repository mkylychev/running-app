package com.app_ghasla.common.extension

import android.content.Context
import android.content.Intent

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)