package com.example.tutorial01.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tutorial01.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieViewAdapter extends BaseAdapter {
    private List<Movie> items = new ArrayList<>();


    public void addItems(List<Movie> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie item = items.get(position);

        final MovieItemView movieItemView = convertView == null ?
                new MovieItemView(parent.getContext()) : (MovieItemView) convertView;

        movieItemView.setImage(item.getPosterPath());
        movieItemView.setTitle(item.getTitle());
        movieItemView.setContent(item.getOverview());

        return movieItemView;
    }
}
