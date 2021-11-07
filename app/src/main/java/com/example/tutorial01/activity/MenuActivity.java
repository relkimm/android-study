package com.example.tutorial01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial01.R;

public class MenuActivity extends AppCompatActivity {
    private Button listButton;
    private Button dialogButton;
    private Button genreButton;
    private Button postButton;
    private Button fragButton;
    private Button tabButton;
    private Button movieMainButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setView();
        setListener();
    }

    private void setView() {
        listButton = findViewById(R.id.list_button);
        dialogButton = findViewById(R.id.dialog_button);
        genreButton = findViewById(R.id.genre_button);
        postButton = findViewById(R.id.post_button);
        fragButton = findViewById(R.id.frag_button);
        tabButton = findViewById(R.id.tab_button);
        movieMainButton = findViewById(R.id.movie_main_button);
    }

    private void setListener() {

        listButton.setOnClickListener((view) -> {
            final Intent intent = new Intent(this, MovieActivity.class);
            startActivity(intent);
        });

        dialogButton.setOnClickListener((view) -> {
            final Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        });

        genreButton.setOnClickListener(view -> {
            final Intent intent = new Intent(this, GenreActivity.class);
            startActivity(intent);
        });

        postButton.setOnClickListener(view -> {
            final Intent intent = new Intent(this, PostActivity.class);
            startActivity(intent);
        });

        fragButton.setOnClickListener(view -> {
            final Intent intent = new Intent(this, FragActivity.class);
            startActivity(intent);
        });

        tabButton.setOnClickListener(view -> {
            final Intent intent = new Intent(this, TabActivity.class);
            startActivity(intent);
        });

        movieMainButton.setOnClickListener(view -> {
            final Intent intent = new Intent(this, MovieMainActivity.class);
            startActivity(intent);
        });
    }
}
