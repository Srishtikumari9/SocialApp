package com.example.socialapp.models;

import com.google.gson.annotations.SerializedName;

public class AccessTokenResponse {
    @SerializedName("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }
}
