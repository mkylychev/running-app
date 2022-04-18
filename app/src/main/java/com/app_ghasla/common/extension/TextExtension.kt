package com.app_ghasla.common.extension

import androidx.core.util.PatternsCompat
import com.app_ghasla.common.constant.emptyString
import com.app_ghasla.common.constant.separator
import com.app_ghasla.common.constant.space
import java.util.*

/**
 * Name: First & Last
 */
fun String.toFirstName(): String {
    return split(space).firstOrNull() ?: emptyString
}

fun String.toLastName(): String {
    val parts = split(space)
    return when (parts.size > 1) {
        true -> parts.last()
        false -> emptyString
    }
}

/**
 * Email Validation
 */
fun String?.isValidEmail(): Boolean {
    return !isNullOrEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
}

/**
 * Session name
 */
fun Int.toSessionName(): String {
    val nextNumber = this + 1
    val date = Date().toSessionNameDate()
    return "$nextNumber-$date"
}

/**
 * Add # to Tags
 */
fun List<String>.tagsToHashTags(): String {
    return joinToString(separator = separator) { "#$it" }
}

fun List<String>.tagsToHashTags(
    isColumn: Boolean = false,
    limit: Int = -1
): String {
    return joinToString(
        separator = if (isColumn) "\n" else separator,
        limit = limit,
        truncated = emptyString
    ) { "#$it" }
}

fun String.removeAllWhiteSpace(): String {
    return this.replace(space, emptyString, true)
}

/**
 * Capitalize first char in words
 */
fun String.capitalizeWords(): String = split(" ").joinToString(" ") { word ->
    word.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
}

fun String.hasSpace(error: String): String? {
    return if (this.contains(space)) {
        error
    } else {
        null
    }
}