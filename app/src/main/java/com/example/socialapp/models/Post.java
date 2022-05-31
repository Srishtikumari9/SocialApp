package com.example.socialapp.models;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                '}';
    }
}
