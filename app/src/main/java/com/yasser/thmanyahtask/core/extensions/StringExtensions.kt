package com.yasser.thmanyahtask.core.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun String.toBearerToken():String{
    return "Bearer $this"
}

fun String.convertToDate(
    dateTimeFormat: String = "yyyy/MM/dd'T'HH:mm",
    timeZone: String? = null
): Date? {
    val df = SimpleDateFormat(dateTimeFormat, Locale.ENGLISH)
    return try {
        df.parse(this)
    } catch (e: ParseException) {
        null
    }

}

fun Date.convertToUiDate(dateFormat: String = "yyyy/MM/dd , hh:mm a"): String {
    val df = SimpleDateFormat(dateFormat, Locale.ENGLISH)
    return df.format(this)
}
