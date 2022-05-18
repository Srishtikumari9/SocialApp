package com.example.socialapp;

import static com.example.socialapp.utils.Constants.CLIENT_ID;
import static com.example.socialapp.utils.Constants.CLIENT_SECRET;
import static com.example.socialapp.utils.Constants.PREF_KEY_ACCESS_TOKEN;
import static com.example.socialapp.utils.Constants.REDIRECT_URI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.socialapp.models.AccessTokenResponse;
import com.example.socialapp.ui.posts.PostsActivity;
import com.example.socialapp.viewmodel.LoginViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NextActivity extends AppCompatActivity {
    public static final String TAG = NextActivity.class.getSimpleName();
    Button btn_posts;
    private LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btn_posts = findViewById(R.id.btn_posts);
        btn_posts.setVisibility(View.GONE);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        btn_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PostsActivity.class);
                startActivity(i);
                //Open Posts Activity
            }
        });
        Intent intent = getIntent();
        Uri data = intent.getData();
        String code = data.getQueryParameter("code");
        getAccessToken(code);
    }

    private void getAccessToken(String code) {
        Log.d(TAG, "Code = " + code);
        Call<AccessTokenResponse> call = loginViewModel.getAccessToken(code, CLIENT_ID, REDIRECT_URI, CLIENT_SECRET);
        call.enqueue(new Callback<AccessTokenResponse>() {
            @Override
            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String accessToken = response.body().getAccessToken();
                        SharedPreferenceHelper.setSharedPreferenceString(NextActivity.this, PREF_KEY_ACCESS_TOKEN, accessToken);
                        SharedPreferenceHelper.getSharedPreferenceString(NextActivity.this, PREF_KEY_ACCESS_TOKEN, "");

                        btn_posts.setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                Log.e(TAG, "AccessTokenError = " + t.toString());
            }
        });
    }
}
