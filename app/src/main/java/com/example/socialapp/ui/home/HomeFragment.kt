package com.example.socialapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp.R
import com.example.socialapp.SharedPreferenceHelper
import com.example.socialapp.models.Posts
import com.example.socialapp.network.livedataadapter.ApiResponse
import com.example.socialapp.utils.Constants
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =  inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        recyclerView = view.findViewById(R.id.recView)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        homeRecyclerViewAdapter = HomeRecyclerViewAdapter(ArrayList())
        recyclerView.adapter = homeRecyclerViewAdapter
        recyclerView.layoutManager = linearLayoutManager
        getPosts()
        return view
    }
    private fun getPosts() {
        val accessToken =
            context?.let {
                SharedPreferenceHelper.getString(
                    it,
                    Constants.PREF_KEY_ACCESS_TOKEN,
                    ""
                )
            }
        accessToken?.let { token ->
            homeViewModel.getPosts("name,description", token)
                .observe(viewLifecycleOwner) { response: ApiResponse<Posts> ->
                    if (response.isSuccessful) {
                        val posts = response.body?.posts
                        posts?.let {
                            homeRecyclerViewAdapter.update(it)
                            Log.i(TAG, it.toTypedArray().contentToString())
                        }

                    } else {
                        Log.d(TAG, response.errorMessage!!)
                    }
                }
        }
    }
    companion object {
        private val TAG = HomeFragment::class.java.simpleName
    }
}


