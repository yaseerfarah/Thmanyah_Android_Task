package com.yasser.thmanyahtask.core.extensions


fun String.toBearerToken():String{
    return "Bearer $this"
}