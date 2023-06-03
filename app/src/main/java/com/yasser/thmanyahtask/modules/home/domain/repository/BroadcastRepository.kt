package com.yasser.thmanyahtask.modules.home.domain.repository

import com.yasser.thmanyahtask.modules.home.domain.entity.BroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.login.domain.entity.AccessTokenEntity


interface BroadcastRepository {

    suspend fun getBroadcastPlaylist(authorization:String):BroadcastPlaylistEntity

}