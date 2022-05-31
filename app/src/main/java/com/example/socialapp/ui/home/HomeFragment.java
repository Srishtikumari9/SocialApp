package com.example.socialapp.ui.home;

import static com.example.socialapp.utils.Constants.PREF_KEY_ACCESS_TOKEN;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialapp.R;
import com.example.socialapp.SharedPreferenceHelper;
import com.example.socialapp.models.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    private View view;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        recyclerView = view.findViewById(R.id.recView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(homeRecyclerViewAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        getPosts();
        return view;
    }

    private void getPosts() {
        String accessToken = SharedPreferenceHelper.getString(getContext(), PREF_KEY_ACCESS_TOKEN, "");
        homeViewModel.getPosts("name,description", accessToken).observe(getViewLifecycleOwner(), response -> {
            if (response.isSuccessful()) {
                List<Post> posts = response.body.getPosts();
                homeRecyclerViewAdapter.update(posts);

                Log.i(TAG, Arrays.toString(posts.toArray()));
            } else {
                Log.d(TAG, response.errorMessage);
            }
        });
    }
}


