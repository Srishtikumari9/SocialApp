package com.example.login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("oauth/access_token")
    Call<AccessTokenResponse> getAccessToken(@Query("code") String code,
                                             @Query("client_id") String clientId,
                                       @Query("redirect_uri") String redirectUri,
                                             @Query("client_secret") String client_secret);
    @GET("me/posts")
    Call<Posts> getPosts(@Query("fields") String fields,@Query("access_token") String accessToken);
}
