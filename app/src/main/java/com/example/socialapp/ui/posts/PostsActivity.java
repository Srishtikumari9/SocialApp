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
import com.example.socialapp.viewmodel.PostViewModel;

import java.util.List;

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
        postViewModel.getPosts("name,description", accessToken).observe(this, response -> {
            if (response.isSuccessful()) {
                List<Post> posts = response.body.getPosts();
                for (Post post : posts) {
                    Log.i(TAG, "" + post.getName());
                }
            } else {
                Log.d(TAG, "PostsError = ");
            }
        });
    }
}


