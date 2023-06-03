package com.yasser.thmanyahtask.modules.login.data.source


import com.google.gson.Gson
import com.yasser.thmanyahtask.BuildConfig
import com.yasser.thmanyahtask.core.network.ApiEndpoints
import com.yasser.thmanyahtask.modules.login.data.model.request.UserLoginRequest
import com.yasser.thmanyahtask.modules.login.data.model.response.AccessTokenResponse
import javax.inject.Inject

class LoginApiSource @Inject constructor(
    private val apiEndpoints: ApiEndpoints
) {

    suspend fun getAccessToken():AccessTokenResponse{
        var accessTokenResponse:AccessTokenResponse?=null
        val response= apiEndpoints.getAccessToken(
            UserLoginRequest(
                email = BuildConfig.Email,
                password = BuildConfig.Password
            )
        )
        if (response.isSuccessful){
            accessTokenResponse= response.body()
        }else{
            val message = "Something went wrong"
            Throwable(message)
        }
        return accessTokenResponse!!
    }




}