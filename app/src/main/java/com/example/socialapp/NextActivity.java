package com.example.socialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NextActivity extends AppCompatActivity {
    Button btn_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btn_posts = findViewById(R.id.btn_posts);

        btn_posts.setVisibility(View.GONE);
        btn_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PostsActivity.class);
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
        Log.d("test", "Code = " + code);
        Call<AccessTokenResponse> call = RetrofitClient.getInstance().getApi().getAccessToken(code, "1848123932049765", "https://letsconnect.com/", "80d7301378a81e9758c559c097caf157");
        call.enqueue(new Callback<AccessTokenResponse>() {
            @Override
            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String accessToken = response.body().getAccessToken();
                        SharedPreferences.Editor editor = getSharedPreferences("LetsConnect", MODE_PRIVATE).edit();
                        editor.putString("accessToken", accessToken);
                        editor.apply();

                        btn_posts.setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                Log.e("Test", "AccessTokenError = " + t.toString());
            }
        });
    }

}
