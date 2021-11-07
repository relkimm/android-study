package com.example.tutorial01.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial01.R;
import com.example.tutorial01.fragment.NowPlayingMovieFragment;

class MovieMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout, new NowPlayingMovieFragment())
                .commit();
    }
}
