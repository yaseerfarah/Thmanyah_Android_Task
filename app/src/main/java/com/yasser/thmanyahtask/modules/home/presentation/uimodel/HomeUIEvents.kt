package com.yasser.thmanyahtask.modules.home.presentation.uimodel

sealed class HomeUIEvents{

   object GetBroadcastData:HomeUIEvents()
   data class ToggleBroadcastToFavorite(val broadcastUiModel: BroadcastUiModel):HomeUIEvents()
}