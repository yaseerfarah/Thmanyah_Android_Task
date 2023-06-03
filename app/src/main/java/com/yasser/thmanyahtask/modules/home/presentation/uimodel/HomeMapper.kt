package com.yasser.thmanyahtask.modules.home.presentation.uimodel

import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.core.extensions.toHours
import com.yasser.thmanyahtask.core.extensions.toMinutes
import com.yasser.thmanyahtask.modules.home.data.model.response.BroadcastPlaylistResponse
import com.yasser.thmanyahtask.modules.home.data.model.response.EpisodeResponse
import com.yasser.thmanyahtask.modules.home.domain.entity.BroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.home.domain.entity.EpisodeEntity
import java.util.concurrent.TimeUnit

fun BroadcastPlaylistEntity.toHomeUiState():HomeUiState{
    return HomeUiState(
        data = this.toBroadcastUiModel(),
        isLoading = false,
        errorMsg = null,
        isNetworkError = false
    )
}

fun BroadcastPlaylistEntity.toBroadcastUiModel():BroadcastUiModel{
    return BroadcastUiModel(
        id=id,
        name=name,
        description=description,
        image=image,
        episodeCount=episodeCount,
        timeUnit=if (episodeTotalDuration.toHours()>0)TimeUnit.HOURS else TimeUnit.MINUTES ,
        episodeTotalDuration=if (episodeTotalDuration.toHours()>0)episodeTotalDuration.toHours() else episodeTotalDuration.toMinutes(),
        createdAt=createdAt,
        followingCount=followingCount,
        episodes = episodes.toListOfEpisodeUiModel()
    )
}

fun List<EpisodeEntity>.toListOfEpisodeUiModel():List<EpisodeUiModel>{
    return this.map { episodeEntity->
        EpisodeUiModel(
            id=episodeEntity.id,
            name=episodeEntity.name,
            description=episodeEntity.description,
            image=episodeEntity.image,
            imageBigger=episodeEntity.imageBigger,
            audioLink=episodeEntity.audioLink,
            duration=episodeEntity.duration,
            durationInSeconds=episodeEntity.durationInSeconds,
            views=episodeEntity.views,
            podcastName=episodeEntity.podcastName,
            releaseDate=episodeEntity.releaseDate,
        )
    }
}

fun Throwable.toHomeUiState():HomeUiState{
    return HomeUiState(
        data = null,
        isLoading = false,
        errorMsg = R.string.msgUnexpextedError,
        isNetworkError = false
    )
}

fun Boolean.toHomeUiState(oldState:HomeUiState):HomeUiState{
    return HomeUiState(
        data = oldState.data,
        isLoading = if(this)oldState.isLoading else false ,
        errorMsg = if (oldState.data==null&&!this) R.string.msgNoInternetConnection else null ,
        isNetworkError = oldState.data==null&&!this,
    )
}