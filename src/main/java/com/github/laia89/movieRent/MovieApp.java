package com.github.laia89.movieRent;

import com.github.laia89.movieRent.controller.MoviesController;
import com.github.laia89.movieRent.service.MovieService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
//import com.example.helloworld.resources.HelloWorldResource;
//import com.example.helloworld.health.TemplateHealthCheck;

public class MovieApp extends Application<MovieConf> {
    public static void main(String[] args) throws Exception {
        new MovieApp().run(args);
    }

    @Override
    public String getName() {
        return "movie-app";
    }

    @Override
    public void initialize(Bootstrap<MovieConf> bootstrap) {
        // Configures Dropwizard to serve /assets folder form url path /
        // We also configure default index file as "movies.html", although
        //   this is usually "index.html".


        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "movies.html"));
    }

    /*@Override
    public void run(com.github.laia89.movieRent.MovieConf configuration,
                    Environment environment) {
        // nothing to do yet
    }*/


    @Override
    public void run(MovieConf configuration, Environment environment) {
        final MoviesController moviesController = new MoviesController( new MovieService() );
        environment.jersey().register(moviesController);
    }

}