package com.yasser.thmanyahtask.modules.login.data.model.mapper

import com.yasser.thmanyahtask.modules.login.data.model.response.AccessTokenResponse
import com.yasser.thmanyahtask.modules.login.domain.entity.AccessTokenEntity

fun AccessTokenResponse.toAccessTokenEntity(): AccessTokenEntity {
    return AccessTokenEntity(
        accessToken = accessToken,
        expiresIn = expiresIn
    )
}