package com.example.socialapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.socialapp.data.repositories.PostsRepository;
import com.example.socialapp.data.repositories.PostsRepositoryImpl;
import com.example.socialapp.models.Posts;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public class PostViewModel extends ViewModel {
    
    private PostsRepository postsRepository;

    public PostViewModel(){

        this.postsRepository = new PostsRepositoryImpl();
    }

    public LiveData<ApiResponse<Posts>> getPosts(String fields, String accessToken){
        return (LiveData<ApiResponse<Posts>>) postsRepository.getPosts(fields,accessToken);
    }
}
