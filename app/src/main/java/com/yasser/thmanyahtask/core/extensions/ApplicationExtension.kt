package com.yasser.thmanyahtask.core.extensions

import android.content.Context
import android.content.res.Configuration
import java.util.*

fun Context.changeLanguage(languageIdentifier: String = "ar"): Context {
    val locale = Locale(languageIdentifier)
    Locale.setDefault(locale)
    val config = Configuration(resources.configuration)
    config.setLocale(locale)
    return this.createConfigurationContext(config)
}