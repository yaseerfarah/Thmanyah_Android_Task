package com.yasser.thmanyahtask.modules.home.presentation.uimodel

import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.core.extensions.convertToDate
import com.yasser.thmanyahtask.core.extensions.convertToUiDate
import com.yasser.thmanyahtask.core.extensions.toHours
import com.yasser.thmanyahtask.core.extensions.toMinutes
import com.yasser.thmanyahtask.modules.home.data.model.response.BroadcastPlaylistResponse
import com.yasser.thmanyahtask.modules.home.data.model.response.EpisodeResponse
import com.yasser.thmanyahtask.modules.home.domain.entity.BroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.home.domain.entity.EpisodeEntity
import java.net.ConnectException
import java.util.concurrent.TimeUnit

fun BroadcastPlaylistEntity.toHomeUiState():HomeUiState{
    return HomeUiState(
        data = this.toBroadcastUiModel(),
        isLoading = false,
        errorMsg = null,
        isNetworkError = false
    )
}


fun BroadcastUiModel.toHomeUiState(isFavorite:Boolean):HomeUiState{
    return HomeUiState(
        data = this.copy(
            isFavorite=isFavorite,
            favoriteIcon = if(isFavorite)R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outline
        ),
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
        episodes = episodes.toListOfEpisodeUiModel(),
        isFavorite = false,
        favoriteIcon = R.drawable.ic_favorite_outline
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
            duration=if (episodeEntity.durationInSeconds.toHours()>0)episodeEntity.durationInSeconds.toHours() else episodeEntity.durationInSeconds.toMinutes(),
            durationInSeconds=episodeEntity.durationInSeconds,
            timeUnit = if (episodeEntity.durationInSeconds.toHours()>0)TimeUnit.HOURS else TimeUnit.MINUTES ,
            views=episodeEntity.views,
            podcastName=episodeEntity.podcastName,
            releaseDate=episodeEntity.releaseDate.convertToDate(dateTimeFormat = "yyyy-MM-dd'T'HH:mm:sss'Z'")?.convertToUiDate()?:episodeEntity.releaseDate,
        )
    }
}

fun Throwable.toHomeUiState():HomeUiState{
    return HomeUiState(
        data = null,
        isLoading = false,
        errorMsg = this.getErrorMessageResource(),
        isNetworkError = this is ConnectException
    )
}

fun Throwable.getErrorMessageResource():Int{
   return when(this){
        is ConnectException -> R.string.msgNoInternetConnection
        else -> R.string.msgUnexpextedError
    }
}




