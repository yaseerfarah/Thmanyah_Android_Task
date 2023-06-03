package com.yasser.thmanyahtask.core.navigation

import android.content.Context
import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 open class RootNavigationCoordinator @Inject constructor(
    val rootFlowNavigation: RootFlowNavigation)
    : NavigationCoordinator<RootNavigationEvent>() {

     override fun init(param: Any) {

     }

     override fun onStart(context: Context?, param: Any?) {

     }

     override fun onEvent(event: RootNavigationEvent) {

     }


 }