package com.example.socialapp.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.socialapp.data.repositories.PostsRepository;
import com.example.socialapp.data.repositories.PostsRepositoryImpl;
import com.example.socialapp.models.Posts;
import com.example.socialapp.network.livedataadapter.ApiResponse;

public class HomeViewModel extends ViewModel {
    public static final String TAG = HomeViewModel.class.getSimpleName();

    private PostsRepository postsRepository;

    public HomeViewModel() {

        this.postsRepository = new PostsRepositoryImpl();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel is destroyed");
    }

    public LiveData<ApiResponse<Posts>> getPosts(String fields, String accessToken) {
        return (LiveData<ApiResponse<Posts>>) postsRepository.getPosts(fields, accessToken);
    }
}
