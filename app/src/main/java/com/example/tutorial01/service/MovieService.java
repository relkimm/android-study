package com.example.tutorial01.service;


import com.example.tutorial01.api.config.RetrofitFactory;
import com.example.tutorial01.api.MovieApi;
import com.example.tutorial01.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MovieService {
    private static MovieService movieService = null;
    private MovieApi movieApi;

    private MovieService(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    public static MovieService getInstance() {
        if(movieService == null) {
            final Retrofit retrofit = RetrofitFactory.create();
            final MovieApi movieApi = retrofit.create(MovieApi.class);
            movieService = new MovieService(movieApi);
        }
        return movieService;
    }

    public Call<MovieResponse> getPopular(int page) {
        return movieApi.getPopular(page);
    }
}
