package com.example.tutorial01.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;

import java.util.ArrayList;
import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ITEM   = 0;
    private static final int VIEW_TYPE_PROGRESS_BAR = 1;
    private List<MovieItem> movieItems = new ArrayList<>();

    public void addItems(List<MovieItem> items) {
        if(movieItems.size() != 0 && getLastItem() == null) {
            this.movieItems.remove(getLastIndex());
        }
        this.movieItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addNullItem() {
        this.movieItems.add(null);
        notifyItemInserted(getItemCount() - 1);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
            return new MovieViewHolder(itemView);
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_bar_item, parent, false);
        return new ProgressBarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MovieViewHolder) {
            final MovieItem movieItem = movieItems.get(position);
            ((MovieViewHolder) holder).bind(movieItem);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return movieItems.get(position) == null ? VIEW_TYPE_PROGRESS_BAR : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    public MovieItem getLastItem() {
        return this.movieItems.get(getLastIndex());
    }

    public int getLastIndex() {
        return this.movieItems.size() - 1;
    }
}
