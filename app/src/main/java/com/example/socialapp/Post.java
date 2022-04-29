package com.example.socialapp;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
