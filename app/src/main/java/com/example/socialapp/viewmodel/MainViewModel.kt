package com.example.socialapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.socialapp.data.repositories.LoginRepository
import com.example.socialapp.data.repositories.LoginRepositoryImpl
import com.example.socialapp.models.AccessTokenResponse
import com.example.socialapp.network.livedataadapter.ApiResponse

class MainViewModel : ViewModel(){
    private val loginRepository: LoginRepository

    init {
        loginRepository = LoginRepositoryImpl()
    }
    fun getAccessToken(
        code: String,
        clientId: String,
        redirectUri: String,
        clientSecret: String
    ): LiveData<ApiResponse<AccessTokenResponse>> {
        return loginRepository.getAccessToken(code, clientId, redirectUri, clientSecret)
    }
}

