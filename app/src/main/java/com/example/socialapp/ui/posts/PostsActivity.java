package com.example.socialapp.ui.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.socialapp.R;
import com.example.socialapp.data.repositories.PostsRepository;
import com.example.socialapp.data.repositories.PostsRepositoryImpl;
import com.example.socialapp.models.Post;
import com.example.socialapp.models.Posts;
import com.example.socialapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    ListView superListView;
    String listviews[] = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        superListView = findViewById(R.id.superListView);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.activity_posts,listviews);
        superListView.setAdapter(arr);

        getPosts();
    }
    private void getPosts() {
        PostsRepository postsRepository = new PostsRepositoryImpl();
        SharedPreferences prefs = getSharedPreferences("LetsConnect", MODE_PRIVATE);
        String accessToken = prefs.getString("accessToken", "");

        Call<Posts> call = postsRepository.getPosts("name,description", accessToken);
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                List<Post> posts = response.body().getPosts();

                for (Post post : posts) {
                    System.out.print("Name - " + post.getName());
                    //superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, onPosts));
                }
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Log.e("Test", "PostsError = " + t.toString());
            }

        });
    }

}