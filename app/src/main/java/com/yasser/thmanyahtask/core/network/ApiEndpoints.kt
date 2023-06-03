package com.yasser.thmanyahtask.core.network

import com.yasser.thmanyahtask.modules.login.data.model.request.UserLoginRequest
import com.yasser.thmanyahtask.modules.login.data.model.response.AccessTokenResponse
import com.yasser.thmanyahtask.modules.home.data.model.response.BroadcastPlaylistResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiEndpoints {


    @POST("auth/login")
    suspend fun getAccessToken(@Body userLoginRequest: UserLoginRequest): Response<AccessTokenResponse>


    @GET("playlist/01GVD0TTY5RRMHH6YMCW7N1H70")
    suspend fun getBroadcastPlaylist(@Header("Authorization") authorization:String): Response<BroadcastPlaylistResponse>





}