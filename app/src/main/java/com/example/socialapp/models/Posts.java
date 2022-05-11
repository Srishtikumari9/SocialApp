package com.example.socialapp.models;

import com.example.socialapp.models.Post;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Posts {
    @SerializedName("data")
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}


