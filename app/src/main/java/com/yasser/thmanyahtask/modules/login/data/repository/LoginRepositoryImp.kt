package com.yasser.thmanyahtask.modules.login.data.repository


import com.yasser.thmanyahtask.core.cache.SharedPrefsHelper
import com.yasser.thmanyahtask.core.extensions.toMilliseconds
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
    private val loginApiSource: LoginApiSource,
    private val sharedPrefsHelper: SharedPrefsHelper
):LoginRepository {
    override suspend fun getAccessToken(): AccessTokenEntity {
        if (!checkValidateData()){
            val accessTokenEntity = loginApiSource.getAccessToken().toAccessTokenEntity()
            saveNewAccessToken(accessTokenEntity)
        }
        return AccessTokenEntity(accessToken = sharedPrefsHelper[SharedPrefsHelper.ACCESS_TOKEN, ""], expiresIn = sharedPrefsHelper[SharedPrefsHelper.EXPIRE_IN, 0])
    }
    private  fun checkValidateData():Boolean{
        val expireInMillisecond=sharedPrefsHelper[SharedPrefsHelper.EXPIRE_IN, 0]
        return System.currentTimeMillis()<(sharedPrefsHelper.get<Long>(SharedPrefsHelper.LAST_UPDATE,0)+expireInMillisecond)
    }
    private  fun saveNewAccessToken(accessTokenEntity:AccessTokenEntity){
        sharedPrefsHelper.save(SharedPrefsHelper.ACCESS_TOKEN,accessTokenEntity.accessToken)
        sharedPrefsHelper.save(SharedPrefsHelper.EXPIRE_IN,accessTokenEntity.expiresIn.toMilliseconds())
        sharedPrefsHelper.save(SharedPrefsHelper.LAST_UPDATE,System.currentTimeMillis())
    }

}