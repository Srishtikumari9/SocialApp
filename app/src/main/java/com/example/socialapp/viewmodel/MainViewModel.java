package com.example.socialapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.socialapp.data.repositories.LoginRepository;
import com.example.socialapp.data.repositories.LoginRepositoryImpl;
import com.example.socialapp.models.AccessTokenResponse;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public class MainViewModel extends ViewModel {
    private LoginRepository loginRepository;

    public MainViewModel(){
        this.loginRepository = new LoginRepositoryImpl();
    }

    public LiveData<ApiResponse<AccessTokenResponse>> getAccessToken(String code, String clientId, String redirectUri, String client_secret) {
        return loginRepository.getAccessToken(code, clientId, redirectUri, client_secret);
    }
}
