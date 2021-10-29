package com.example.tutorial01.model;

import java.io.Serializable;
import java.util.List;

public class GenreResponse implements Serializable {
    List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
