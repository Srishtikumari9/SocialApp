package com.example.socialapp.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.socialapp.models.Posts;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public interface PostsRepository {
    LiveData<ApiResponse<Posts>> getPosts(String fields, String accessToken);
}

