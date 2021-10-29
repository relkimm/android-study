package com.example.tutorial01.api.config;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class QueryParamInterceptor implements Interceptor {
    private static final String API_KEY = "789299aabaf3daa544bbce4db9a12c86";
    private static final String LANGUAGE = "ko";
    private static final String REGION = "KR";

    @Override
    public Response intercept(Chain chain) throws IOException {
        final HttpUrl newHttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .addQueryParameter("language", LANGUAGE)
                .addQueryParameter("region", REGION)
                .build();

        final Request newRequest = chain.request()
                .newBuilder()
                .url(newHttpUrl)
                .build();

        return chain.proceed(newRequest);
    }
}
