package com.example.socialapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.socialapp.models.Posts
import com.example.socialapp.network.livedataadapter.ApiResponse

interface PostsRepository {

    fun getPosts(fields: String, accessToken: String): LiveData<ApiResponse<Posts>>
}
