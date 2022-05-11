package com.example.socialapp.data.repositories;

import com.example.socialapp.models.Posts;

import retrofit2.Call;

public interface PostsRepository {
    Call<Posts> getPosts(String fields, String accessToken);
}
