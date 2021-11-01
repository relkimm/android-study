package com.example.tutorial01.service;

import com.example.tutorial01.api.GenreApi;
import com.example.tutorial01.api.config.RetrofitFactory;
import com.example.tutorial01.model.GenreResponse;

import io.reactivex.Flowable;
import retrofit2.Retrofit;

public class GenreService {
    private static GenreService genreService = null;
    private GenreApi genreApi;

    private GenreService(GenreApi genreApi) {
        this.genreApi = genreApi;
    }

    public static GenreService getInstance() {
        if(genreService == null) {
            final Retrofit retrofit = RetrofitFactory.create();
            final GenreApi genreApi = retrofit.create(GenreApi.class);
            genreService = new GenreService(genreApi);
        }
        return genreService;
    }

    public Flowable<GenreResponse> getGenres() {
        return genreApi.getGenres();
    }
}
