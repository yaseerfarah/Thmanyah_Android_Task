package com.yasser.thmanyahtask.modules.home.presentation.adapter.listener

import com.yasser.thmanyahtask.modules.home.presentation.uimodel.BroadcastUiModel
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.EpisodeUiModel

interface BroadcastActionListener {

    fun onBackClick()
    fun onFavoriteClick(broadcastUiModel: BroadcastUiModel)
    fun onOptionClick()
    fun onPlayRandomEpisodesClick()
    fun onDownloadClick()
    fun onPlayEpisodesClick()


}