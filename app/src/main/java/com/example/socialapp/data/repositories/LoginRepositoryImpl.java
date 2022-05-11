package com.example.socialapp.data.repositories;

import com.example.socialapp.models.AccessTokenResponse;
import com.example.socialapp.network.RetrofitClient;

import retrofit2.Call;

public class LoginRepositoryImpl implements LoginRepository{

    @Override
    public Call<AccessTokenResponse> getAccessToken(String code, String clientId, String redirectUri, String client_secret) {
        return RetrofitClient.getInstance().getApi().getAccessToken(code, clientId, redirectUri, client_secret);
    }
}
