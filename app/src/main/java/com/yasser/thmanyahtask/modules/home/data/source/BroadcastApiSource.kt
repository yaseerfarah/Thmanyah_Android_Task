package com.yasser.thmanyahtask.modules.home.data.source


import com.google.gson.Gson
import com.yasser.thmanyahtask.BuildConfig
import com.yasser.thmanyahtask.core.network.ApiEndpoints
import com.yasser.thmanyahtask.modules.home.data.model.response.BroadcastPlaylistResponse
import com.yasser.thmanyahtask.modules.login.data.model.request.UserLoginRequest
import com.yasser.thmanyahtask.modules.login.data.model.response.AccessTokenResponse
import javax.inject.Inject

class BroadcastApiSource @Inject constructor(
    private val apiEndpoints: ApiEndpoints
) {

    suspend fun getBroadcastPlaylist(accessToken:String):BroadcastPlaylistResponse{
        var broadcastPlaylistResponse:BroadcastPlaylistResponse?=null
        val response= apiEndpoints.getBroadcastPlaylist(
            authorization = accessToken
        )
        if (response.isSuccessful){
            broadcastPlaylistResponse= response.body()
        }else{
            val message = "Something went wrong"
            Throwable(message)
        }
        return broadcastPlaylistResponse!!
    }




}