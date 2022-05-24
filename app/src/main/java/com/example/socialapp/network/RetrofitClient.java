package com.example.socialapp.network;


import static com.example.socialapp.utils.Constants.FACEBOOK_GRAPH_URL;

import com.example.socialapp.network.livedataadapter.LiveDataCallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Api api;
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    private RetrofitClient() {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofitAuth = new Retrofit.Builder()
                .baseUrl(FACEBOOK_GRAPH_URL)
                .client(client)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        api = retrofitAuth.create(Api.class);

    }
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getApi() {

        return api;
    }

}

