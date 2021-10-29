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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listButton = findViewById(R.id.list_button);
        dialogButton = findViewById(R.id.dialog_button);
        genreButton = findViewById(R.id.genre_button);

        listButton.setOnClickListener((view) -> {
            final Intent intent = new Intent(this, ListActivity.class);
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
    }
}
