package com.app_ghasla.core.model.common

import androidx.annotation.ColorRes
import com.app_ghasla.R

enum class InputFieldState(@ColorRes val strokeColor: Int) {
    Normal(strokeColor = android.R.color.transparent),
    Focused(strokeColor = R.color.blue),
    Error(strokeColor = R.color.red)
}