package com.example.tutorial01.view;

import com.example.tutorial01.model.Genre;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GenreItem {
    private long id;
    private String name;

    private GenreItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static GenreItem of(Genre genre) {
        return new GenreItem(genre.getId(), genre.getName());
    }
}
