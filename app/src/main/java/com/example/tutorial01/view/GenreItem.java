package com.example.tutorial01.view;

import com.example.tutorial01.model.Genre;

public class GenreItem {
    private String name;

    private GenreItem(String name) {
        this.name = name;
    }

    public static GenreItem of(Genre genre) {
        return new GenreItem(genre.getName());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
