package com.example.socialapp;

import static com.example.socialapp.utils.Constants.CLIENT_ID;
import static com.example.socialapp.utils.Constants.CLIENT_SECRET;
import static com.example.socialapp.utils.Constants.PREF_KEY_ACCESS_TOKEN;
import static com.example.socialapp.utils.Constants.REDIRECT_URI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.socialapp.ui.home.ErrorFragment;
import com.example.socialapp.ui.home.HomeFragment;
import com.example.socialapp.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Intent intent = getIntent();
        Uri data = intent.getData();
        String code = data.getQueryParameter("code");
        getAccessToken(code);
    }

    private void getAccessToken(String code) {
        Log.d(TAG, "Code = " + code);
        mainViewModel.getAccessToken(code, CLIENT_ID, REDIRECT_URI, CLIENT_SECRET).observe(this, response -> {
            if (response.isSuccessful()) {
                SharedPreferenceHelper.setString(MainActivity.this, PREF_KEY_ACCESS_TOKEN, response.body.getAccessToken());
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
            } else {
                Log.d(TAG, response.errorMessage);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ErrorFragment()).commit();
            }
        });
    }
}

