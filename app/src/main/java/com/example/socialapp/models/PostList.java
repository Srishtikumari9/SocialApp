package com.example.socialapp.models;

public class PostList {
    private String name;
    private String posts;

    public PostList(String name, String posts) {
        this.name = name;
        this.posts = posts;
    }

    public PostList() {
    }

    public String getName() {
        return name;
    }

    public String setName() {
        return name;
    }

    public String getPosts() {
        return posts;
    }

}

