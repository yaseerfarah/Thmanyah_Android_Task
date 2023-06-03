package com.yasser.thmanyahtask.core.cache.di

import android.content.Context
import com.yasser.thmanyahtask.core.cache.SharedPrefsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CacheModule {
    @Provides
    @Singleton
    fun sharedPrefs(@ApplicationContext context: Context):SharedPrefsHelper{
        return SharedPrefsHelper(context)
    }
}