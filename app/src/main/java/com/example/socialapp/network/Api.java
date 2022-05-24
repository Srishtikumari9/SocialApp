package com.example.socialapp.network;

import androidx.lifecycle.LiveData;

import com.example.socialapp.models.AccessTokenResponse;
import com.example.socialapp.models.Posts;
import com.example.socialapp.network.livedataadapter.ApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("oauth/access_token")
    LiveData<ApiResponse<AccessTokenResponse>> getAccessToken(@Query("code") String code,
                                                              @Query("client_id") String clientId,
                                                              @Query("redirect_uri") String redirectUri,
                                                              @Query("client_secret") String client_secret);

    @GET("me/posts")
    LiveData<ApiResponse<Posts>> getPosts(@Query("fields") String fields, @Query("access_token") String accessToken);
}