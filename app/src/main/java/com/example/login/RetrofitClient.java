package com.example.login;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        Retrofit retrofitAuth = new Retrofit.Builder().baseUrl("https://graph.facebook.com/v13.0/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofitAuth.create(Api.class);

       /* Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
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

