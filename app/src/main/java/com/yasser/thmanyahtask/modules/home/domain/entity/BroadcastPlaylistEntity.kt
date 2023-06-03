package com.yasser.thmanyahtask.modules.home.domain.entity

import com.yasser.thmanyahtask.modules.home.data.model.response.EpisodeResponse
import com.yasser.thmanyahtask.modules.home.data.model.response.PlaylistResponse

data class BroadcastPlaylistEntity(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val episodeCount: Long,
    val episodeTotalDuration: Long,
    val createdAt: String,
    val followingCount: Long,
    val episodes:List<EpisodeEntity>
)
