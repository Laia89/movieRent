package com.github.laia89.movieRent.controller;

import com.codahale.metrics.annotation.Timed;
import com.github.laia89.movieRent.api.Saying;
import com.github.laia89.movieRent.model.Movie;
import com.github.laia89.movieRent.service.MovieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/api/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    /*@GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }*/

    @GET
    public Collection<Movie> showMovies() {
        System.out.println(movieService.getAllMovies());
        return movieService.getAllMovies();
    }

    @GET
    @Path("{id}")
    public Movie showMovieById(@PathParam("id") int id) {
        return movieService.getMovieById(id);
    }

    @POST
    public Movie addMovie(Movie movie) {
        System.out.println("Received Movie: " + movie);
        return movieService.addMovie(movie);
    }


    /*
    *
    * GET /movies : obtener todos* los libros
GET /movies/{id} : obtener sólo el libro con el ID indicado
POST /movies : añadir libro (en la llamada se envía body con los datos del libro)
PUT /movies/{id} : modificar libro indicado (se envía body con los datos del libro)
DELETE /movies/{id} : modificar libro indicado
    * */
}