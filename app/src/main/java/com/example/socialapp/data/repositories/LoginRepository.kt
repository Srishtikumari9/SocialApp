package com.example.socialapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.socialapp.models.AccessTokenResponse
import com.example.socialapp.network.livedataadapter.ApiResponse

interface LoginRepository {

    fun getAccessToken(
        code: String,
        clientId: String,
        redirectUri: String,
        clientSecret: String
    ): LiveData<ApiResponse<AccessTokenResponse>>
}
