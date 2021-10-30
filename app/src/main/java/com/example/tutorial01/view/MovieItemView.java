package com.example.tutorial01.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tutorial01.R;

public class MovieItemView extends LinearLayout {
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original";
    private ImageView imageView;
    private TextView titleView;
    private TextView contentView;

    public MovieItemView(Context context) {
        super(context);
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.movie_list_item, this, true);

        imageView = findViewById(R.id.item_image);
        titleView = findViewById(R.id.item_title);
        contentView = findViewById(R.id.item_content);
    }

    public void setImage(String imageUrl) {
        final String url = String.format("%s%s", IMAGE_BASE_URL, imageUrl);
        Glide.with(this).load(url).into(imageView);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setContent(String content) {
        contentView.setText(content);
    }
}
