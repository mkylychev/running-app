package com.app_ghasla.common.extension

import android.graphics.drawable.Drawable
import android.widget.ImageView
import coil.load
import coil.transition.CrossfadeTransition
import java.io.File

fun ImageView.setImage(file: File?) {
    if (file == null) return
    this.load(file) {
        transitionFactory(CrossfadeTransition.Factory())
    }
}

fun ImageView.setImage(drawable: Drawable?) {
    if (drawable == null) return
    this.load(drawable) {
        transitionFactory(CrossfadeTransition.Factory())
    }
}

fun ImageView.setImage(url: String?) {
    if (drawable == null) return
    this.load(drawable) {
        transitionFactory(CrossfadeTransition.Factory())
    }
}