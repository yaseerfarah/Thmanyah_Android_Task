package com.yasser.thmanyahtask.modules.main.presentation.viewmodel

import android.content.Context
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiState
import com.yasser.thmanyahtask.base.presentation.viewmodel.StateViewModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.BottomNavEnum
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context,
    ):
    StateViewModel<MainUiModel, MainUiState, MainUIEvents>(MainUiState(currentScreen = BottomNavEnum.HOME)) {
    override fun mapStateToUIModel(oldState: MainUiState, newState: MainUiState): MainUiModel {
        return MainUiModel(
            currentScreen = newState.currentScreen
        )
    }

    override fun sendEvent(event: MainUIEvents) {
        when(event){
            is MainUIEvents.NavigateToScreen -> navigateToScreen(event.bottomNavEnum)
        }
    }

    private fun navigateToScreen(bottomNavEnum: BottomNavEnum){
        if (state.currentScreen!=bottomNavEnum){
            updateState(state.copy(currentScreen = bottomNavEnum))
        }
    }

}