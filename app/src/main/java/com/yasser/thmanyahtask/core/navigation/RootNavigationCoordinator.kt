package com.yasser.thmanyahtask.core.navigation

import android.content.Context
import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import com.yasser.thmanyahtask.modules.main.presentation.navigation.MainNavigationEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 open class RootNavigationCoordinator @Inject constructor(
    private val rootFlowNavigation: RootFlowNavigation,
    private val mainNavigationCoordinator: NavigationCoordinator<MainNavigationEvent>
    )
    : NavigationCoordinator<RootNavigationEvent>() {

     override fun init(param: Any) {

     }

     override fun onStart(context: Context?, param: Any?) {
         mainNavigationCoordinator.onStart(context,param)
     }

     override fun onEvent(event: RootNavigationEvent) {

     }


 }