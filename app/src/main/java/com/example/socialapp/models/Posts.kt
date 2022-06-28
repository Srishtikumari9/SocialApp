package com.example.socialapp.models

import com.google.gson.annotations.SerializedName

data class Posts(@SerializedName("data") val posts: List<Post>) {

}
