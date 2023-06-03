package com.yasser.thmanyahtask.modules.login.data.repository


import com.yasser.thmanyahtask.modules.login.data.model.mapper.toAccessTokenEntity
import com.yasser.thmanyahtask.modules.login.data.source.LoginApiSource
import com.yasser.thmanyahtask.modules.login.domain.entity.AccessTokenEntity
import com.yasser.thmanyahtask.modules.login.domain.repository.LoginRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class LoginRepositoryImp@Inject constructor(
    private val loginApiSource: LoginApiSource
):LoginRepository {
    override suspend fun getAccessToken(): AccessTokenEntity {
        return loginApiSource.getAccessToken().toAccessTokenEntity()
    }


}