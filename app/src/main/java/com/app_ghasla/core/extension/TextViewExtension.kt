package com.app_ghasla.core.extension

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView

fun TextView.setColoredText(string: String, colorString: String, color: Int) {
    val spannableString = SpannableString(string)
    if (string.contains(colorString)) {
        spannableString.setSpan(
            ForegroundColorSpan(color),
            string.indexOf(colorString),
            string.indexOf(colorString) + colorString.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    text = spannableString
}