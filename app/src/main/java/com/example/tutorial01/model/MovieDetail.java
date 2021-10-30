package com.example.tutorial01.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class MovieDetail implements Serializable {
    private long id;
    private String title;
    private String overview;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private List<Genre> genres = new ArrayList<>();
    @SerializedName("release_date")
    private String releaseDate;
}
