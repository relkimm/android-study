package com.example.tutorial01.api;

import com.example.tutorial01.model.MovieDetail;
import com.example.tutorial01.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("/3/movie/popular")
    Call<MovieResponse> getPopular(@Query("page") int page);
    @GET("/3/movie/{movie_id}")
    Call<MovieDetail> getDetail(@Path("movie_id") long movieId);
}
