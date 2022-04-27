package com.app_ghasla.core.model

import android.graphics.drawable.Drawable
import com.app_ghasla.core.constant.emptyString

data class OnBoardingItem(
    val drawable: Drawable? = null,
    val title: String = emptyString
)