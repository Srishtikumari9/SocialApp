package com.example.socialapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.socialapp.data.repositories.PostsRepository
import com.example.socialapp.data.repositories.PostsRepositoryImpl
import com.example.socialapp.models.Posts
import com.example.socialapp.network.livedataadapter.ApiResponse

class HomeViewModel : ViewModel() {
    private val postsRepository: PostsRepository
    companion object {
        val TAG: String = HomeViewModel::class.java.simpleName
    }
    init {
        postsRepository = PostsRepositoryImpl()
    }
    fun getPosts(fields: String, accessToken: String): LiveData<ApiResponse<Posts>> {
        return postsRepository.getPosts(fields, accessToken)
    }
}