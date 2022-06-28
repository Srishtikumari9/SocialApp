package com.example.socialapp.models
import com.google.gson.annotations.SerializedName

data class Post(@SerializedName("name") val name: String,
                @SerializedName("id") val id : String){
}



