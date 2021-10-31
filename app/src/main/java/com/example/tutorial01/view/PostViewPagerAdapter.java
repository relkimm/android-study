package com.example.tutorial01.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.R;

import java.util.ArrayList;
import java.util.List;

public class PostViewPagerAdapter extends RecyclerView.Adapter<PostViewPagerHolder> {
    private List<String> postImageUrls = new ArrayList<>();

    public void setItems(List<String> items) {
       this.postImageUrls.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.post_list_item, parent, false);

        return new PostViewPagerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewPagerHolder holder, int position) {
        final String postImageUrl = postImageUrls.get(position);
        holder.bind(postImageUrl);
    }

    @Override
    public int getItemCount() {
        return postImageUrls.size();
    }
}
