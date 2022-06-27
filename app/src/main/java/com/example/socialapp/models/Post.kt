package com.example.socialapp.models
import com.google.gson.annotations.SerializedName
class Post {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: String? = null
    override fun toString(): String {
        return "Post{" +
                "name='" + name + '\'' +
                '}'
    }
}


