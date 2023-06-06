package com.yasser.thmanyahtask.modules.splash.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiState
import com.yasser.thmanyahtask.base.presentation.viewmodel.StateViewModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.BottomNavEnum
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEvents
import com.yasser.thmanyahtask.modules.splash.presentation.uimodel.SplashUIEvents
import com.yasser.thmanyahtask.modules.splash.presentation.uimodel.SplashUiModel
import com.yasser.thmanyahtask.modules.splash.presentation.uimodel.SplashUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @ApplicationContext context: Context,
    ):
    StateViewModel<SplashUiModel, SplashUiState, SplashUIEvents>(SplashUiState(navigateToNextScreen = false)) {
    override fun mapStateToUIModel(
        oldState: SplashUiState,
        newState: SplashUiState
    ): SplashUiModel {
        return SplashUiModel(
            navigateToNextScreen = newState.navigateToNextScreen
        )
    }

    override fun sendEvent(event: SplashUIEvents) {
        when(event){
            is SplashUIEvents.StartSplashDelay->startSplashDelay()
        }
    }

    private fun startSplashDelay(){
        viewModelScope.launch {
            delay(2000)
            updateState(state.copy(navigateToNextScreen = true))
        }
    }


}