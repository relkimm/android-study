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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView titleView;
    private TextView contentView;
    private RecyclerView genreListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("MovieDetail Activcity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initView();

        final long movieId = getIntent().getLongExtra("movieId", 0);
        fetchMovieDetail(movieId);
    }

    private void initView() {
        imageView = findViewById(R.id.movie_detail_post);
        titleView = findViewById(R.id.movie_detail_title);
        contentView = findViewById(R.id.movie_detail_content);
        genreListView = findViewById(R.id.movie_detail_genre_list);
    }

    private void fetchMovieDetail(long movieId) {
        MovieService.getInstance()
                .getDetail(movieId)
                .enqueue(new Callback<MovieDetail>() {
                    @Override
                    public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                        final MovieDetail movieDetail = response.body();
                        System.out.println(movieDetail.toString());
                        bindMovieDetail(movieDetail);

                    }

                    @Override
                    public void onFailure(Call<MovieDetail> call, Throwable t) {

                    }
                });
    }

    private void bindMovieDetail(MovieDetail movieDetail) {
        final String baseUrl = "https://image.tmdb.org/t/p/original";
        Glide.with(MovieDetailActivity.this).load(baseUrl + movieDetail.getBackdropPath()).into(imageView);
        titleView.setText(movieDetail.getTitle());
        contentView.setText(movieDetail.getOverview());
    }
}
