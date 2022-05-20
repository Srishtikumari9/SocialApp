package com.example.socialapp.ui.posts;

import static com.example.socialapp.utils.Constants.PREF_KEY_ACCESS_TOKEN;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.socialapp.R;
import com.example.socialapp.SharedPreferenceHelper;
import com.example.socialapp.models.Post;
import com.example.socialapp.models.Posts;
import com.example.socialapp.viewmodel.PostViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    ListView superListView;
    String listviews[] = {};
    private PostViewModel postViewModel;
    public static final String TAG = PostsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        superListView = findViewById(R.id.superListView);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.activity_posts, listviews);
        superListView.setAdapter(arr);

        getPosts();
    }

    private void getPosts() {
        String accessToken = SharedPreferenceHelper.getString(PostsActivity.this, PREF_KEY_ACCESS_TOKEN, "");
        Call<Posts> call = postViewModel.getPosts("name,description", accessToken);
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                List<Post> posts = response.body().getPosts();

                for (Post post : posts) {
                    Log.i(TAG, "" + post.getName());
                }
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Log.e(TAG, "PostsError = " + t.toString());
            }

        });
    }

}