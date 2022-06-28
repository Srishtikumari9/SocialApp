package com.example.socialapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.socialapp.models.AccessTokenResponse
import com.example.socialapp.network.RetrofitClient
import com.example.socialapp.network.livedataadapter.ApiResponse

class LoginRepositoryImpl : LoginRepository {
    override fun getAccessToken(
        code: String,
        clientId: String,
        redirectUri: String,
        clientSecret: String
    ): LiveData<ApiResponse<AccessTokenResponse>> {
        return RetrofitClient.api.getAccessToken(
            code,
            clientId,
            redirectUri,
            clientSecret
        )
    }
}

