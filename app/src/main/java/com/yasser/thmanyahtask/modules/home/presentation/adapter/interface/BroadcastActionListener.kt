package com.yasser.thmanyahtask.modules.home.presentation.adapter.`interface`

import com.yasser.thmanyahtask.modules.home.presentation.uimodel.EpisodeUiModel

interface BroadcastActionListener {

    fun onBackClick()
    fun onFavoriteClick()
    fun onOptionClick()
    fun onPlayRandomEpisodesClick()
    fun onDownloadClick()
    fun onPlayEpisodesClick()
    fun onSpecificEpisodePlayClick(episodeUiModel: EpisodeUiModel)
    fun onSpecificEpisodeMenuClick(episodeUiModel: EpisodeUiModel)

}