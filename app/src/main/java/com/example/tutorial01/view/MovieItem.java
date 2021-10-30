package com.example.tutorial01.view;

import com.example.tutorial01.model.Movie;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MovieItem {
    private long id;
    private String title;
    private String content;
    private String imageUrl;

    private MovieItem(long id, String title, String content, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public static MovieItem of(Movie movie) {
        final String baseUrl = "https://image.tmdb.org/t/p/original";
        final String imageUrl = String.format("%s%s", baseUrl, movie.getPosterPath());
        return new MovieItem(
                movie.getId(),
                movie.getTitle(),
                movie.getOverview(),
                imageUrl
        );
    }
}
