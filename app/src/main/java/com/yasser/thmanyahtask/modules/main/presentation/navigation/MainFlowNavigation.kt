package com.yasser.thmanyahtask.modules.main.presentation.navigation


import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFlowNavigation @Inject constructor(){

    private lateinit var navController:NavController

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun navigateToHomeScreen(){

    }
    fun navigateToSearchScreen(){

    }
    fun navigateToLibraryScreen(){

    }
}