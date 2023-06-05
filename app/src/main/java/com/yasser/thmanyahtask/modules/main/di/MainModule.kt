package com.yasser.thmanyahtask.modules.main.di


import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import com.yasser.thmanyahtask.modules.main.presentation.navigation.MainFlowNavigation
import com.yasser.thmanyahtask.modules.main.presentation.navigation.MainNavigationCoordinator
import com.yasser.thmanyahtask.modules.main.presentation.navigation.MainNavigationEvent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideMainNavigationCoordinator(
        mainFlowNavigation: MainFlowNavigation
    ): NavigationCoordinator<MainNavigationEvent> =
        MainNavigationCoordinator(
            mainFlowNavigation =mainFlowNavigation
        )
}
