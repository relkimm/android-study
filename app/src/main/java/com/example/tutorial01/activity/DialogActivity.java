package com.example.tutorial01.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tutorial01.R;

public class DialogActivity extends AppCompatActivity {
    private Button alertButton;
    private Button datePickerButton;
    private Button timePickerButton;
    private Button naverButton;

    private static final String NAVER_URL = "https://www.naver.com";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        alertButton = findViewById(R.id.alert_button);
        datePickerButton = findViewById(R.id.date_picker_button);
        timePickerButton = findViewById(R.id.time_picker_button);
        naverButton = findViewById(R.id.naver_button);

        alertButton.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setTitle("앱 종료")
                    .setPositiveButton("종료", (dialog, which) -> finish())
                    .setNegativeButton("취소", (dialog, which) -> {})
                    .show();
        });

        datePickerButton.setOnClickListener(view -> {

        });

        timePickerButton.setOnClickListener(view -> {

        });

        naverButton.setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(NAVER_URL)));
        });

    }
}
