package com.example.tutorial01.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial01.R;
import com.example.tutorial01.fragment.MainFragment;
import com.example.tutorial01.fragment.MenuFragment;

public class FragActivity extends AppCompatActivity {
    private Button startButton;
    private Button menuButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        startButton = findViewById(R.id.start_button);
        menuButton = findViewById(R.id.menu_button);

        startButton.setOnClickListener(view -> changeFragment(1));
        menuButton.setOnClickListener(view -> changeFragment(2));
    }

    public void changeFragment(int index) {
        if(index == 1) {
            final MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, mainFragment).commit();
        } else if(index == 2) {
            final MenuFragment menuFragment = new MenuFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menuFragment).commit();
        }
    }
}
