package com.example.tutorial01.view;

import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;

public class ProgressBarViewHolder extends RecyclerView.ViewHolder {
    private ProgressBar progressBar;

    public ProgressBarViewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progress_bar_item);
    }
}
