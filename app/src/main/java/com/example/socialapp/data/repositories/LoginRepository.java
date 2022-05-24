package com.example.socialapp.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.socialapp.models.AccessTokenResponse;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public interface LoginRepository {
    LiveData<ApiResponse<AccessTokenResponse>> getAccessToken(String code,
                                                              String clientId,
                                                              String redirectUri,
                                                              String client_secret);
}
