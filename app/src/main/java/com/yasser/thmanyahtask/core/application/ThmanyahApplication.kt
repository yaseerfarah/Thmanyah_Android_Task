package com.yasser.thmanyahtask.core.application

import android.app.Application
import android.content.res.Configuration
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.yasser.thmanyahtask.core.extensions.changeLanguage
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ThmanyahApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        changeLanguage("ar")
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}

