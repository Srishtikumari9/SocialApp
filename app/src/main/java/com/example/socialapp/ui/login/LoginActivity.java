package com.example.socialapp.ui.login;

import static com.example.socialapp.utils.Constants.CLIENT_ID;
import static com.example.socialapp.utils.Constants.FACEBOOK_OAUTH_URL;
import static com.example.socialapp.utils.Constants.REDIRECT_URI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.socialapp.R;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = LoginActivity.class.getSimpleName();
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        Log.i(TAG, "onCreate() LoginView Model is initialized");
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = FACEBOOK_OAUTH_URL + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
    }
}
