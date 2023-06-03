package com.yasser.thmanyahtask.modules.login.domain.repository

import com.yasser.thmanyahtask.modules.login.domain.entity.AccessTokenEntity


interface LoginRepository {

    suspend fun getAccessToken():AccessTokenEntity

}