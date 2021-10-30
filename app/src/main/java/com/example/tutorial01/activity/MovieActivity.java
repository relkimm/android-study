package com.example.tutorial01.activity;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.view.MovieItem;
import com.example.tutorial01.view.MovieViewAdapter;
import com.example.tutorial01.R;
import com.example.tutorial01.model.Movie;
import com.example.tutorial01.model.MovieResponse;
import com.example.tutorial01.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView movieListView;
    private MovieViewAdapter movieViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movieListView = findViewById(R.id.movie_list);
        movieViewAdapter = new MovieViewAdapter();
        movieListView.setAdapter(movieViewAdapter);
        movieListView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        MovieService.getInstance()
            .getPopular(1)
            .enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                    if(response.isSuccessful() == false) {
                        Log.e("연결 성공X", "response code: " + response.code());
                        return;
                    }

                    Log.d("연결 성공", "response code: " + response.code());
                    final List<MovieItem> movieItems = response.body().getResults()
                            .stream()
                            .map(MovieItem::of)
                            .collect(Collectors.toList());

                    movieViewAdapter.addItems(movieItems);
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Log.e("연결 실패", t.getMessage());
                }
            });
    }
}
