package com.vishal.appinventiv.service;

import com.vishal.appinventiv.entity.Movie;
import com.vishal.appinventiv.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //Save on Movie at a time, Using inbuilt JPa method=save
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    //Saves multiple movies at once
    public List<Movie> createMovies(List<Movie> movies){
        return movieRepository.saveAll(movies);
    }

    //Get all movies present in the Database
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    //get Movie by ID, if ID is not known or incorrect "null" is returned
    public Movie getMovie(int id){
        return movieRepository.findById(id).orElse(null);
    }

    //Delete movie by ID, returns confirmation message with ID
    public String deleteMovie(int id){
        movieRepository.deleteById(id);
        return("Movie with the ID: "+id+" deleted from the List !!");
    }

    //Update uses the findById method to fetch the existing record using ID.
    //Which is saved into an object of Movie type and later uses set methods to update values and save in DB
    public Movie updateMovie(Movie movie){
        Movie existingMovie = movieRepository.findById(movie.getId()).orElse(null);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setCategory(movie.getCategory());
        existingMovie.setRating(movie.getRating());
        return movieRepository.save(existingMovie);
    }

}
