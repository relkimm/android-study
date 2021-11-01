package com.example.tutorial01.api;

import com.example.tutorial01.model.MovieDetail;
import com.example.tutorial01.model.MovieResponse;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("/3/movie/popular")
    Flowable<MovieResponse> getPopular(@Query("page") int page);
    @GET("/3/movie/{movie_id}")
    Flowable<MovieDetail> getDetail(@Path("movie_id") long movieId);
}
