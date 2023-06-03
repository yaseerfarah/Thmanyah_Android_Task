package com.yasser.thmanyahtask.modules.home.data.repository


import com.yasser.thmanyahtask.modules.home.data.model.mapper.toBroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.home.data.source.BroadcastApiSource
import com.yasser.thmanyahtask.modules.home.domain.entity.BroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.home.domain.repository.BroadcastRepository
import com.yasser.thmanyahtask.modules.login.data.model.mapper.toAccessTokenEntity
import com.yasser.thmanyahtask.modules.login.data.source.LoginApiSource
import com.yasser.thmanyahtask.modules.login.domain.entity.AccessTokenEntity
import com.yasser.thmanyahtask.modules.login.domain.repository.LoginRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class BroadcastRepositoryImp@Inject constructor(
    private val broadcastApiSource: BroadcastApiSource
):BroadcastRepository {
    override suspend fun getBroadcastPlaylist(authorization: String): BroadcastPlaylistEntity {
        return  broadcastApiSource.getBroadcastPlaylist(authorization).toBroadcastPlaylistEntity()
    }


}