package com.emreonal.cvapp.util.extensions

import android.content.Context
import com.emreonal.cvapp.R
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT_YEAR_MONTH = "MMM yyyy"


fun Date?.betweenDateExperience(endDate: Date?, context: Context): String? {
    if (this == null) return null

    val end = endDate ?: Calendar.getInstance().time

    val diff = end.time - this.time
    val diffMoths = (diff /  ( 24 * 60 * 60 * 1000) / 30).toInt() + 1
    val years = diffMoths / 12
    val months = diffMoths % 12
    val yearStr = if (years > 1) {
        "$years ${context.getString(R.string.years)}"
    } else if (years > 0){
        "$years ${context.getString(R.string.year)}"
    } else {
        ""
    }
    val monthStr = if (months > 1) {
        "$months ${context.getString(R.string.months)}"
    } else if (years > 0){
        "$months ${context.getString(R.string.month)}"
    } else {
        ""
    }

    val datesStr = if (endDate == null) {
        "${this.parseDate(DATE_FORMAT_YEAR_MONTH)} - ${context.getString(R.string.present)}"
    } else {
        "${this.parseDate(DATE_FORMAT_YEAR_MONTH)} - ${endDate.parseDate(DATE_FORMAT_YEAR_MONTH)}"
    }

    return if (yearStr.isNotEmpty()) "$datesStr $yearStr $monthStr" else "$datesStr $monthStr"
}
private fun getDifferenceDays(d1: Date, d2: Date): Int {
    var daysDiff = 0
    val diff = d2.time - d1.time
    val diffDays = diff / (24 * 60 * 60 * 1000) + 1
    daysDiff = diffDays.toInt()
    return daysDiff
}

fun Date?.parseDate(sourceFormat: String): String? {
    if (this == null) {
        return null
    }
    val sdf = SimpleDateFormat(sourceFormat, Locale.getDefault())
    try {
        return sdf.format(this)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
    return null
}