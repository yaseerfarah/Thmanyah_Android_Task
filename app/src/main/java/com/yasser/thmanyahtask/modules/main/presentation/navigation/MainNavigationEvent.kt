package com.yasser.thmanyahtask.modules.main.presentation.navigation

sealed class  MainNavigationEvent {

    object NavigateToHomeScreen:MainNavigationEvent()
    object NavigateToSearchScreen:MainNavigationEvent()
    object NavigateToLibraryScreen:MainNavigationEvent()

}