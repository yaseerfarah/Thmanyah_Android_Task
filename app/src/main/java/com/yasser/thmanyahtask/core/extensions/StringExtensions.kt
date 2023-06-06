package com.yasser.thmanyahtask.core.extensions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun String.toBearerToken():String{
    return "Bearer $this"
}

fun String.convertToDate(
    dateTimeFormat: String = "yyyy-MM-dd",
    languageCode:String="ar",
    timeZone: String = "UTC"
): Date? {
    val df = SimpleDateFormat(dateTimeFormat, Locale(languageCode))
    df.timeZone = TimeZone.getTimeZone(timeZone)
    return try {
        df.parse(this)
    } catch (e: ParseException) {
        null
    }

}

fun Date.convertToUiDate(): String {
    val yearFormat = SimpleDateFormat("yyyy", Locale("en"))
    val monthFormat = SimpleDateFormat("MMMM", Locale("ar"))
    return "${yearFormat.format(this)} ${monthFormat.format(this)}"
}
