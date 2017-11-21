package com.zeng.demo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class MoviesWraper {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovieList() {
        return movies;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movies = movieList;
    }
}
