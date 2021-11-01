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
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView movieListView;
    private MovieViewAdapter movieViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private MovieService movieService;

    private int page = 1;
    private boolean isLoading = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setView();
        setService();
        initScrollListener();
        fetchPopularMovie(page);
    }

    private void setView() {
        movieListView = findViewById(R.id.movie_list);
        movieViewAdapter = new MovieViewAdapter();
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,  false);
        movieListView.setAdapter(movieViewAdapter);
        movieListView.setLayoutManager(linearLayoutManager);
    }

    private void setService() {
        movieService = MovieService.getInstance();
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
        movieService.getPopular(page)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(MovieResponse::getResults)
                .flatMap(Flowable::fromIterable)
                .map(MovieItem::of)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showMovies);
    }

    private void showMovies(List<MovieItem> movieItems) {
        movieViewAdapter.addItems(movieItems);
        isLoading = false;
    }
}
