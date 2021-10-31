package com.example.tutorial01.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tutorial01.R;
import com.example.tutorial01.view.PostViewPagerAdapter;

import java.util.Arrays;
import java.util.List;

public class PostActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private PostViewPagerAdapter postViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        viewPager2 = findViewById(R.id.post_view_pager);
        postViewPagerAdapter = new PostViewPagerAdapter();
        viewPager2.setAdapter(postViewPagerAdapter);

        final List<String> postUrls = fetchPostUrls();
        postViewPagerAdapter.setItems(postUrls);
    }

    private List<String> fetchPostUrls() {
        final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original";
        return Arrays.asList(
                IMAGE_BASE_URL + "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                IMAGE_BASE_URL + "/Aebz7s8EHQXxHR98J8Vw6QVGggq.jpg",
                IMAGE_BASE_URL + "/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
        );

    }
}
