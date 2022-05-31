package com.example.socialapp.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.socialapp.models.Posts;
import com.example.socialapp.network.RetrofitClient;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public class PostsRepositoryImpl implements PostsRepository {

    @Override
    public LiveData<ApiResponse<Posts>> getPosts(String fields, String accessToken) {
        return RetrofitClient.getInstance().getApi().getPosts(fields, accessToken);
    }
}

