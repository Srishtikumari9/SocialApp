package com.example.socialapp.data.repositories;

import com.example.socialapp.models.Posts;
import com.example.socialapp.network.RetrofitClient;

import retrofit2.Call;

public class PostsRepositoryImpl implements PostsRepository{

    @Override
    public Call<Posts> getPosts(String fields, String accessToken) {
        return RetrofitClient.getInstance().getApi().getPosts(fields,accessToken);
    }
}
