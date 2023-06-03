package com.yasser.thmanyahtask.modules.home.data.model.response

data class BroadcastPlaylistResponse(
    val data: DataResponse
)

data class DataResponse(
    val playlist: PlaylistResponse,
    val episodes:List<EpisodeResponse>
)



data class PlaylistResponse(
    val id: String,
    val type: Long,
    val name: String,
    val description: String,
    val image: String,
    val access: String,
    val status: String,
    val episodeCount: Long,
    val episodeTotalDuration: Long,
    val createdAt: String,
    val updatedAt: String,
    val isDeleted: Boolean,
    val followingCount: Long,
    val userId: String,
    val isSubscribed: Boolean,
)

data class EpisodeResponse(
    val id: String,
    val itunesId: String,
    val type: Long,
    val name: String,
    val description: String,
    val image: String,
    val imageBigger: String,
    val audioLink: String,
    val duration: Long,
    val durationInSeconds: Long,
    val views: Long,
    val podcastItunesId: String,
    val podcastName: String,
    val releaseDate: String,
    val createdAt: String,
    val updatedAt: String,
    val isDeleted: Boolean,
    val isEditorPick: Boolean,
    val sentNotification: Boolean,
    val position: Long,
)

