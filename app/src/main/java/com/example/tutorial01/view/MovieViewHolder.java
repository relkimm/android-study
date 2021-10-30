package com.example.tutorial01.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial01.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView titleView;
    private TextView contentView;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.item_image);
        titleView = itemView.findViewById(R.id.item_title);
        contentView = itemView.findViewById(R.id.item_content);
    }

    public void bind(MovieItem movieItem) {
        Glide.with(super.itemView).load(movieItem.getImageUrl()).into(imageView);
        titleView.setText(movieItem.getTitle());
        contentView.setText(movieItem.getContent());
    }
}
