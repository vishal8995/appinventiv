package com.vishal.appinventiv.controller;

import com.vishal.appinventiv.entity.Movie;
import com.vishal.appinventiv.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    //Autowiring MovieService as all methods to fetch from DB are written in the same
    @Autowired
    private MovieService movieService;

    //Post Mapping to Save one Movie, RequestBody used as entire Movie object is fetched in form of JSON
    @PostMapping("/save")
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    //Post Mapping to Save a list of Movies
    @PostMapping("/saveall")
    public List<Movie> saveMovies(@RequestBody List<Movie> movies){
        return movieService.createMovies(movies);
    }

    @GetMapping("/fetchall")
    public List<Movie> fetchAllMovies(){
        return movieService.getMovies();
    }

    //Get Mapping to get Movie, Path Variable used as ID is passed as request from API
    @GetMapping("/fetch/{id}")
    public Movie fetchMovie(@PathVariable int id){
        return movieService.getMovie(id);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id){
        return movieService.deleteMovie(id);
    }

}
