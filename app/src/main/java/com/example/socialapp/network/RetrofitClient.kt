package com.example.socialapp.network

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.example.socialapp.network.livedataadapter.LiveDataCallAdapterFactory
import com.example.socialapp.utils.Constants
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient  {
    val api: Api
    private var interceptor = HttpLoggingInterceptor()
    init {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofitAuth = Retrofit.Builder()
            .baseUrl(Constants.FACEBOOK_GRAPH_URL)
            .client(client)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofitAuth.create(Api::class.java)
    }
}
