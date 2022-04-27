package com.app_ghasla.core.extension

import androidx.annotation.IdRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.setHorizontalBias(
    @IdRes targetViewId: Int,
    bias: Float
) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this)
    constraintSet.setHorizontalBias(targetViewId, bias)
    constraintSet.applyTo(this)
}