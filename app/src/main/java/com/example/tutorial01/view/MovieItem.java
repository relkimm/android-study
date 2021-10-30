package com.example.tutorial01.view;

import com.example.tutorial01.model.Movie;

public class MovieItem {
    private String imageUrl;
    private String title;
    private String content;

    private MovieItem(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public static MovieItem of(Movie movie) {
        final String baseUrl = "https://image.tmdb.org/t/p/original";
        final String imageUrl = String.format("%s%s", baseUrl, movie.getPosterPath());
        return new MovieItem(imageUrl, movie.getTitle(), movie.getOverview());
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
