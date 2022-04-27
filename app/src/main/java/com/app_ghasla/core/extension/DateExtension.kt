package com.app_ghasla.core.extension

import android.app.DatePickerDialog
import androidx.fragment.app.Fragment
import com.app_ghasla.core.constant.emptyString
import java.text.SimpleDateFormat
import java.util.*

private const val simpleDatePattern = "dd.MM.yyyy"
private const val fullDatePattern = "HH:mm, dd.MM.yyyy"
private const val simpleTimePattern = "HH:mm"
private const val sessionNameDatePattern = "yyyyMMdd"

private fun getSimpleDateFormat(pattern: String): SimpleDateFormat {
    return SimpleDateFormat(pattern, Locale.getDefault())
}

/**
 * Current Date
 */
val currentDate: Date get() = Calendar.getInstance().time

/**
 * Simple
 */
fun Date?.toSimpleDate(): String = runCatching {
    this?.let { getSimpleDateFormat(simpleDatePattern).format(this) } ?: emptyString
}.getOrElse { emptyString }

/**
 * Full
 */
fun Date?.toFullDate(): String = runCatching {
    this?.let { getSimpleDateFormat(fullDatePattern).format(this) } ?: emptyString
}.getOrElse { emptyString }

/**
 * Simple time
 */
fun Date?.toSimpleTime(): String = runCatching {
    this?.let { getSimpleDateFormat(simpleTimePattern).format(this) } ?: emptyString
}.getOrElse { emptyString }


/**
 * Session name
 */
fun Date?.toSessionNameDate(): String = runCatching {
    this?.let { getSimpleDateFormat(sessionNameDatePattern).format(this) } ?: emptyString
}.getOrElse { emptyString }

/**
 * Convert Date to Calendar
 */
fun Date?.toCalendar(): Calendar? = runCatching {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar
}.getOrNull()

/**
 * Get Calendar start and end date to compare time stamp in firestore
 */
fun Calendar?.startDay(): Date = runCatching {
    this?.let {
        set(Calendar.HOUR, 0)
        set(Calendar.MINUTE, 0)
        time
    } ?: Date()
}.getOrElse { Date() }

fun Calendar?.endDay(): Date = runCatching {
    this?.let {
        set(Calendar.HOUR, 23)
        set(Calendar.MINUTE, 59)
        time
    } ?: Date()
}.getOrElse { Date() }

/**
 * Show date picker dialog
 */
fun Fragment.showDatePickerDialog(
    date: Calendar = Calendar.getInstance(),
    callback: (date: Calendar) -> Unit = {}
) {
    DatePickerDialog(
        requireContext(),
        { _, year, monthOfYear, dayOfMonth ->
            date.apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, monthOfYear)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }
            callback(date)
        },
        date.get(Calendar.YEAR),
        date.get(Calendar.MONTH),
        date.get(Calendar.DAY_OF_MONTH)
    ).show()
}