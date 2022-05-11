package com.example.socialapp.data.repositories;

import com.example.socialapp.models.AccessTokenResponse;

import retrofit2.Call;

public interface LoginRepository {
    Call<AccessTokenResponse> getAccessToken(String code,
                                             String clientId,
                                             String redirectUri,
                                             String client_secret);
}
