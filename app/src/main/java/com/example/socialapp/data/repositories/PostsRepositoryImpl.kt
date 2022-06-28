package com.example.socialapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.socialapp.models.Posts
import com.example.socialapp.network.RetrofitClient
import com.example.socialapp.network.livedataadapter.ApiResponse

class PostsRepositoryImpl : PostsRepository {
    override fun getPosts(fields: String, accessToken: String): LiveData<ApiResponse<Posts>> {
        return RetrofitClient.api.getPosts(fields, accessToken)
    }
}
