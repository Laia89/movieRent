package com.github.laia89.movieRent.service;

import com.github.laia89.movieRent.model.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieService {

    private Map<Integer, Movie> movies;
    private int nextId;

    public MovieService() {
        movies = new HashMap<>();
        movies.put(1, new Movie(1, "Tres bodas y un funeral"));
        movies.put(2, new Movie(2, "El señor de los anillos"));
        movies.put(3, new Movie(3, "Paseando a Miss Daisy"));

        nextId = 4;
    }

    public Collection<Movie> getAllMovies() {
        final Collection<Movie> allmovies;
        allmovies = movies.values();
        return allmovies;
    }

    public Movie getMovieById(int id) {
        return movies.get(id);
    }

    public Movie addMovie(Movie movie) {
        movie.setId(nextId);
        movies.put(nextId, movie);
        nextId++;
        return movie;
    }


}
