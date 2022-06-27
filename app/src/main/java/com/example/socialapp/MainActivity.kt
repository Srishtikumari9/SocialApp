package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import com.example.socialapp.viewmodel.MainViewModel
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import android.util.Log
import com.example.socialapp.network.livedataadapter.ApiResponse
import com.example.socialapp.models.AccessTokenResponse
import com.example.socialapp.ui.home.HomeFragment
import com.example.socialapp.ui.home.ErrorFragment
import com.example.socialapp.utils.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val intent = intent
        val data = intent.data
        val code = data?.getQueryParameter("code")
        code?.let {  getAccessToken(code) }
    }
    private fun getAccessToken(code: String) {
        Log.d(TAG, "Code = $code")
        mainViewModel.getAccessToken(
            code,
            Constants.CLIENT_ID,
            Constants.REDIRECT_URI,
            Constants.CLIENT_SECRET
        ).observe(this) { response: ApiResponse<AccessTokenResponse> ->
            if (response.isSuccessful) {
                response.body?. let { SharedPreferenceHelper.setString(
                    this@MainActivity,
                    Constants.PREF_KEY_ACCESS_TOKEN,
                    it.accessToken
                ) }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, HomeFragment()).commit()
            } else {
                response.errorMessage?.let {  Log.d(TAG, it) }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, ErrorFragment()).commit()
            }
        }
    }
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
