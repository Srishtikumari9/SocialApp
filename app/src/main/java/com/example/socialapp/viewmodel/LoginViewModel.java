package com.example.socialapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.socialapp.data.repositories.LoginRepository;
import com.example.socialapp.data.repositories.LoginRepositoryImpl;
import com.example.socialapp.models.AccessTokenResponse;

import retrofit2.Call;

public class LoginViewModel extends ViewModel {
    public static final String TAG = LoginViewModel.class.getSimpleName();

    private LoginRepository loginRepository;

    public LoginViewModel() {

        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel is destroyed");
    }

    public Call<AccessTokenResponse> getAccessToken(String code, String clientId, String redirectUri, String client_secret) {
        return loginRepository.getAccessToken(code, clientId, redirectUri, client_secret);
    }
}