package com.yasser.thmanyahtask.modules.main.presentation.navigation

import android.content.Context
import androidx.navigation.NavController
import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import com.yasser.thmanyahtask.modules.main.presentation.view.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 open class MainNavigationCoordinator @Inject constructor(
    val mainFlowNavigation: MainFlowNavigation)
    : NavigationCoordinator<MainNavigationEvent>() {

     override fun init(param: Any) {
         mainFlowNavigation.setNavController(param as NavController)
     }

     override fun onStart(context: Context?, param: Any?) {
         MainActivity.startInstance(context)
     }

     override fun onEvent(event: MainNavigationEvent) {
         when(event){
             is MainNavigationEvent.NavigateToHomeScreen->mainFlowNavigation.navigateToHomeScreen()
             is MainNavigationEvent.NavigateToSearchScreen->mainFlowNavigation.navigateToSearchScreen()
             is MainNavigationEvent.NavigateToLibraryScreen->mainFlowNavigation.navigateToLibraryScreen()
         }
     }


 }