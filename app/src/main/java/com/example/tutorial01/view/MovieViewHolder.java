package com.example.tutorial01.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial01.R;
import com.example.tutorial01.activity.MovieDetailActivity;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleView;
    private TextView contentView;
    private static long movieId = 0;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_image);
        titleView = itemView.findViewById(R.id.item_title);
        contentView = itemView.findViewById(R.id.item_content);

        itemView.setOnClickListener(view -> {
            final Context context = view.getContext();
            final Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("movieId", movieId);
            context.startActivity(intent);
        });
    }

    public void bind(MovieItem movieItem) {
        Glide.with(super.itemView).load(movieItem.getImageUrl()).into(imageView);
        titleView.setText(movieItem.getTitle());
        contentView.setText(movieItem.getContent());
        this.movieId = movieItem.getId();
    }
}
