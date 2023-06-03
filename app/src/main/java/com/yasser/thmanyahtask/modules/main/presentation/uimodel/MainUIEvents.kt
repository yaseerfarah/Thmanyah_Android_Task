package com.yasser.thmanyahtask.modules.main.presentation.uimodel

sealed class MainUIEvents{

   data class NavigateToScreen(val bottomNavEnum: BottomNavEnum):MainUIEvents()

}