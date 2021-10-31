package com.example.tutorial01.view;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial01.R;

public class PostViewPagerHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public PostViewPagerHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.post_list_item);
    }

    public void bind(String postImageUrl) {
        Glide.with(super.itemView).load(postImageUrl).into(imageView);
    }
}
