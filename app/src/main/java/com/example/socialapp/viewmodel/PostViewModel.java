package com.example.socialapp.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.socialapp.data.repositories.PostsRepository;
import com.example.socialapp.data.repositories.PostsRepositoryImpl;
import com.example.socialapp.models.Posts;

import retrofit2.Call;

public class PostViewModel extends ViewModel {
    
    private PostsRepository postsRepository;

    public PostViewModel(){
        this.postsRepository = new PostsRepositoryImpl();
    }

    public Call<Posts> getPosts(String fields, String accessToken){
        return postsRepository.getPosts(fields,accessToken);
    }
}
