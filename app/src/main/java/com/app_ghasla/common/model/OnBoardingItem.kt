package com.app_ghasla.common.model

import android.graphics.drawable.Drawable
import com.app_ghasla.common.constant.emptyString

data class OnBoardingItem(
    val drawable: Drawable? = null,
    val title: String = emptyString
)