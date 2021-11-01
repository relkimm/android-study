package com.example.tutorial01.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tutorial01.R;
import com.example.tutorial01.model.MovieDetail;
import com.example.tutorial01.service.MovieService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView titleView;
    private TextView contentView;
    private RecyclerView genreListView;
    private MovieService movieService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setView();
        setService();

        final long movieId = getIntent().getLongExtra("movieId", 0);
        fetchMovieDetail(movieId);
    }

    private void setView() {
        imageView = findViewById(R.id.movie_detail_post);
        titleView = findViewById(R.id.movie_detail_title);
        contentView = findViewById(R.id.movie_detail_content);
        genreListView = findViewById(R.id.movie_detail_genre_list);
    }

    private void setService() {
        movieService = MovieService.getInstance();
    }

    private void fetchMovieDetail(long movieId) {
        movieService.getDetail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showMovieDetail);
    }

    private void showMovieDetail(MovieDetail movieDetail) {
        final String baseUrl = "https://image.tmdb.org/t/p/original";
        Glide.with(MovieDetailActivity.this).load(baseUrl + movieDetail.getBackdropPath()).into(imageView);
        titleView.setText(movieDetail.getTitle());
        contentView.setText(movieDetail.getOverview());
    }
}
