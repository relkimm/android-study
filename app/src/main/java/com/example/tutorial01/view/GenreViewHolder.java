package com.example.tutorial01.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;

public class GenreViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public GenreViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.genre_name);
    }

    public void bind(GenreItem genreItem) {
        textView.setText(genreItem.getName());
    }
}
