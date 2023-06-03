package com.yasser.thmanyahtask.modules.home.data.model.mapper

import com.yasser.thmanyahtask.modules.home.data.model.response.BroadcastPlaylistResponse
import com.yasser.thmanyahtask.modules.home.data.model.response.EpisodeResponse
import com.yasser.thmanyahtask.modules.home.domain.entity.BroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.home.domain.entity.EpisodeEntity

fun BroadcastPlaylistResponse.toBroadcastPlaylistEntity():BroadcastPlaylistEntity{
    return BroadcastPlaylistEntity(
        id=data.playlist.id,
        name=data.playlist.name,
        description=data.playlist.description,
        image=data.playlist.image,
        episodeCount=data.playlist.episodeCount,
        episodeTotalDuration=data.playlist.episodeTotalDuration,
        createdAt=data.playlist.createdAt,
        followingCount=data.playlist.followingCount,
        episodes = data.episodes.toListOfEpisodeEntity()
    )
}

fun List<EpisodeResponse>.toListOfEpisodeEntity():List<EpisodeEntity>{
    return this.map { episodeResponse->
        EpisodeEntity(
             id=episodeResponse.id,
             name=episodeResponse.name,
             description=episodeResponse.description,
             image=episodeResponse.image,
             imageBigger=episodeResponse.imageBigger,
             audioLink=episodeResponse.audioLink,
             duration=episodeResponse.duration,
             durationInSeconds=episodeResponse.durationInSeconds,
             views=episodeResponse.views,
             podcastName=episodeResponse.podcastName,
             releaseDate=episodeResponse.releaseDate,
        )
    }
}