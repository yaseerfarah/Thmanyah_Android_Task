package com.yasser.thmanyahtask.core.extensions


fun Long.toHours():Long{
    return this / 3600
}

fun Long.toMinutes():Long{
    return(this % 3600) / 60
}

fun Long.toMilliseconds():Long{
    return this*1000
}