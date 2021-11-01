package com.example.tutorial01.api.config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.themoviedb.org/";

    private RetrofitFactory() {}

    public static Retrofit create() {
        if(retrofit == null) {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new QueryParamInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
