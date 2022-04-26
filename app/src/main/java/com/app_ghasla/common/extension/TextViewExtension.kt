package com.app_ghasla.common.extension

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.getFont
import com.app_ghasla.R

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

fun TextView.setLink(string: String, linkString: String, context: Context, block: () -> Unit) {
    SpannableStringBuilder().apply {
        append(string)
        setSpan(object : ClickableSpan() {
            override fun updateDrawState(textPaint: TextPaint) {
                textPaint.also {
                    it.typeface =
                        Typeface.create(getFont(context, R.font.poppins_semi_bold), Typeface.BOLD)
                    it.color = getColor(R.color.blue)
                    it.isUnderlineText = false
                }
            }

            override fun onClick(view: View) {
                block.invoke()
            }
        }, length - linkString.length, length, 0)
    }.also {
        highlightColor = Color.TRANSPARENT
        movementMethod = LinkMovementMethod.getInstance()
        setText(it, TextView.BufferType.SPANNABLE)
    }
}