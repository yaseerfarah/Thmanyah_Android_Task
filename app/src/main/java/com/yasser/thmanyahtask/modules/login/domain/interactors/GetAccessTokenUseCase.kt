package com.yasser.thmanyahtask.modules.login.domain.interactors


import com.yasser.thmanyahtask.base.domain.interactors.SuspendUseCase
import com.yasser.thmanyahtask.core.extensions.toBearerToken
import com.yasser.thmanyahtask.modules.login.domain.repository.LoginRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val repository: LoginRepository
): SuspendUseCase<Unit, String>() {
    override suspend fun invoke(params: Unit): String {
      return repository.getAccessToken().accessToken.toBearerToken()
    }
}