package com.yasser.thmanyahtask.modules.home.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.moviecompose.modules.details.presentation.uimodel.MainUiModel
import com.example.moviecompose.modules.details.presentation.uimodel.MainUiState
import com.yasser.thmanyahtask.base.presentation.viewmodel.StateViewModel
import com.yasser.thmanyahtask.core.network.NetworkStatusTracker
import com.yasser.thmanyahtask.modules.home.domain.interactors.GetBroadcastPlaylistUseCase
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.*
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.BottomNavEnum
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEffects
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val getBroadcastPlaylistUseCase: GetBroadcastPlaylistUseCase,
    private val networkStatusTracker: NetworkStatusTracker
    ):
    StateViewModel<HomeUiModel, HomeUiState, HomeUIEffects, HomeUIEvents>(HomeUiState(data = null, isLoading = true, errorMsg = null, isNetworkError = false)) {


    init {
        listenToNetworkState()
    }

    override fun mapStateToUIModel(oldState: HomeUiState, newState: HomeUiState): HomeUiModel {
        return HomeUiModel(
            data = newState.data,
            errorMsg = newState.errorMsg,
            showLoading = newState.isLoading,
            showNetworkError = newState.isNetworkError && newState.errorMsg!=null,
            showUnexpectedError = newState.errorMsg!=null && newState.data?.episodeCount == 0L,
            showEmptyState = newState.data?.episodeCount == 0L &&newState.errorMsg==null
        )
    }

    override fun sendEvent(event: HomeUIEvents) {
        when(event){
            is HomeUIEvents.GetBroadcastData->getBroadcastPlaylist()
        }
    }


    private fun getBroadcastPlaylist(){
        updateState(HomeUiState(data = null, isLoading = true, errorMsg = null, isNetworkError = false))
        viewModelScope.launch{
            try {
                val broadcastData= withContext(Dispatchers.IO){getBroadcastPlaylistUseCase(Unit)}
                updateState(broadcastData.toHomeUiState())
            }catch (e:Throwable){
                updateState(e.toHomeUiState())
            }


        }
    }

    private fun listenToNetworkState(){
        viewModelScope.launch {
            networkStatusTracker.networkStatus.collect{
                updateState(it.toHomeUiState(state))
            }
        }
    }

}