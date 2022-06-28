package com.example.socialapp.ui.login
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.socialapp.R
import com.example.socialapp.utils.Constants

class LoginActivity : AppCompatActivity() {
    lateinit var btnlogin: Button

    companion object {
        private val TAG = LoginActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin = findViewById(R.id.btn_login)
        Log.i(TAG, "onCreate() LoginView Model is initialized")

        btnlogin.setOnClickListener {
            val url =
                Constants.FACEBOOK_OAUTH_URL + "?client_id=" + Constants.CLIENT_ID + "&redirect_uri=" + Constants.REDIRECT_URI
            Log.d("url", "" + url)
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}
