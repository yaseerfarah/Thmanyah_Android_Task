package com.yasser.thmanyahtask.modules.home.domain.entity

data class EpisodeEntity(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val imageBigger: String,
    val audioLink: String,
    val duration: Long,
    val durationInSeconds: Long,
    val views: Long,
    val podcastName: String,
    val releaseDate: String,

)
