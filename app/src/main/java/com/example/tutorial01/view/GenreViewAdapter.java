package com.example.tutorial01.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;

import java.util.ArrayList;
import java.util.List;

public class GenreViewAdapter extends RecyclerView.Adapter<GenreViewHolder> {
    private List<GenreItem> genreItems = new ArrayList<>();

    public void setItems(List<GenreItem> genreItems) {
        this.genreItems = genreItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) parent
                .getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View itemView = inflater.inflate(R.layout.genre_list_item, parent, false);

        return new GenreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        holder.bind(genreItems.get(position));
    }

    @Override
    public int getItemCount() {
        return genreItems.size();
    }
}
