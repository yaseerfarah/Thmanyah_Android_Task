package com.yasser.thmanyahtask.modules.home.presentation.uimodel

import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import java.util.concurrent.TimeUnit


data class BroadcastUiModel(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val episodeCount: Long,
    val episodeTotalDuration: Long,
    val timeUnit: TimeUnit,
    val createdAt: String,
    val followingCount: Long,
    val isFavorite:Boolean,
   @DrawableRes val favoriteIcon:Int,
    val episodes:List<EpisodeUiModel>
)

data class EpisodeUiModel(
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
    ){

    fun areContentsSame(oldModel:EpisodeUiModel):Boolean{
        return id == oldModel.id
                && name == oldModel.name
                && description == oldModel.description
                && image == oldModel.image
                && imageBigger == oldModel.imageBigger
                && audioLink == oldModel.audioLink
                && duration == oldModel.duration
                && durationInSeconds == oldModel.durationInSeconds
                && views == oldModel.views
                && podcastName == oldModel.podcastName
                && releaseDate == oldModel.releaseDate
    }
}



object EpisodeDiffUtils:DiffUtil.ItemCallback<EpisodeUiModel>(){
    override fun areItemsTheSame(oldItem: EpisodeUiModel, newItem: EpisodeUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EpisodeUiModel, newItem: EpisodeUiModel): Boolean {
       return newItem.areContentsSame(oldItem)
    }

}