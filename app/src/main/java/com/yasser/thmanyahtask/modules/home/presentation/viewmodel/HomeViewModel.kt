package com.yasser.thmanyahtask.modules.home.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.yasser.thmanyahtask.base.presentation.viewmodel.StateViewModel
import com.yasser.thmanyahtask.modules.home.domain.interactors.GetBroadcastPlaylistUseCase
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.*
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
    ):
    StateViewModel<HomeUiModel, HomeUiState, HomeUIEffects, HomeUIEvents>(HomeUiState(data = null, isLoading = true, errorMsg = null, isNetworkError = false)) {



    override fun mapStateToUIModel(oldState: HomeUiState, newState: HomeUiState): HomeUiModel {
        return HomeUiModel(
            data = newState.data,
            errorMsg = newState.errorMsg,
            showLoading = newState.isLoading,
            showNetworkError = newState.isNetworkError && newState.errorMsg!=null,
            showUnexpectedError = newState.errorMsg!=null && (newState.data?.episodeCount == 0L||newState.data==null),
            showEmptyState = newState.data?.episodeCount == 0L &&newState.errorMsg==null
        )
    }

    override fun sendEvent(event: HomeUIEvents) {
        when(event){
            is HomeUIEvents.GetBroadcastData->getBroadcastPlaylist()
            is HomeUIEvents.ToggleBroadcastToFavorite->toggleBroadcastFavorite(event.broadcastUiModel)
        }
    }


    private fun toggleBroadcastFavorite(broadcastUiModel: BroadcastUiModel){
        updateState(broadcastUiModel.toHomeUiState(!broadcastUiModel.isFavorite))
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



}