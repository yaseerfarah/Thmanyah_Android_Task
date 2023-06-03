package com.yasser.thmanyahtask.modules.home.domain.interactors


import com.yasser.thmanyahtask.base.domain.interactors.SuspendUseCase
import com.yasser.thmanyahtask.core.extensions.toBearerToken
import com.yasser.thmanyahtask.modules.home.domain.entity.BroadcastPlaylistEntity
import com.yasser.thmanyahtask.modules.home.domain.repository.BroadcastRepository
import com.yasser.thmanyahtask.modules.login.domain.interactors.GetAccessTokenUseCase
import com.yasser.thmanyahtask.modules.login.domain.repository.LoginRepository
import javax.inject.Inject

class GetBroadcastPlaylistUseCase @Inject constructor(
    private val repository: BroadcastRepository,
    private val getAccessTokenUseCase: GetAccessTokenUseCase
): SuspendUseCase<Unit, BroadcastPlaylistEntity>() {
    override suspend fun invoke(params: Unit): BroadcastPlaylistEntity {
        val accessToken= getAccessTokenUseCase(Unit)
      return repository.getBroadcastPlaylist(accessToken)
    }
}