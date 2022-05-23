package com.example.socialapp.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.socialapp.models.AccessTokenResponse;
import com.example.socialapp.network.RetrofitClient;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public LiveData<ApiResponse<AccessTokenResponse>> getAccessToken(String code, String clientId, String redirectUri, String client_secret) {
        return RetrofitClient.getInstance().getApi().getAccessToken(code, clientId, redirectUri, client_secret);
    }
}
