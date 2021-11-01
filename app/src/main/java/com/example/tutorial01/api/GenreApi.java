package com.example.tutorial01.api;

import com.example.tutorial01.model.GenreResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface GenreApi {
    @GET("/3/genre/movie/list")
    Flowable<GenreResponse> getGenres();
}
