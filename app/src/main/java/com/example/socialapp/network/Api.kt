package com.example.socialapp.network

import androidx.lifecycle.LiveData
import com.example.socialapp.models.AccessTokenResponse
import com.example.socialapp.models.Posts
import com.example.socialapp.network.livedataadapter.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("oauth/access_token")
    fun getAccessToken(
        @Query("code") code : String,
        @Query("client_id") clientId : String,
        @Query("redirect_uri") redirectUri:String,
        @Query("client_secret") clientSecret:String
    ): LiveData<ApiResponse<AccessTokenResponse>>

    @GET("me/posts")
    fun getPosts(
        @Query("fields") fields: String,
        @Query("access_token") accessToken:String
    ): LiveData<ApiResponse<Posts>>
}

