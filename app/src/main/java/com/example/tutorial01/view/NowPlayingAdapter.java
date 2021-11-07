package com.example.tutorial01.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial01.R;

import java.util.ArrayList;
import java.util.List;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder> {
    private List<MovieItem> items = new ArrayList<>();

    @NonNull
    @Override
    public NowPlayingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.now_playing_movie_item, parent, false);

        return new NowPlayingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingViewHolder holder, int position) {
        final MovieItem movieItem = items.get(position);
        holder.bind(movieItem);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(List<MovieItem> movieItems) {
        this.items.addAll(movieItems);
        notifyDataSetChanged();
    }

    public static class NowPlayingViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public NowPlayingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.now_playing_movie_item);
        }

        public void bind(MovieItem movieItem) {
            Glide.with(super.itemView).load(movieItem.getImageUrl()).into(this.imageView);
        }
    }
}
