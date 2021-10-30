package com.example.tutorial01.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial01.view.MovieItem;
import com.example.tutorial01.view.MovieViewAdapter;
import com.example.tutorial01.R;
import com.example.tutorial01.model.MovieResponse;
import com.example.tutorial01.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView movieListView;
    private MovieViewAdapter movieViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int page = 1;
    private boolean isLoading = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movieListView = findViewById(R.id.movie_list);

        movieViewAdapter = new MovieViewAdapter();
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,  false);

        movieListView.setAdapter(movieViewAdapter);
        movieListView.setLayoutManager(linearLayoutManager);

        initScrollListener();
        fetchPopularMovie(page);
    }

    private void initScrollListener() {
        movieListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(isLoading == false) {
                    final int lastPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    if(lastPosition == movieViewAdapter.getItemCount() - 1) {
                        isLoading = true;
                        movieViewAdapter.addNullItem();
                        fetchPopularMovie(page++);
                    }
                }
            }
        });
    }

    private void fetchPopularMovie(int page) {
        MovieService.getInstance()
                .getPopular(page)
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
                        isLoading = false;
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Log.e("연결 실패", t.getMessage());
                    }
                });
    }
}
