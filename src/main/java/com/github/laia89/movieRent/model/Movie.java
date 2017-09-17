package com.github.laia89.movieRent.model;

public class Movie {
    private int id;
    private String title;

    // Default constructor necessary for DW jersey POSTs
    public Movie() {
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

}
