package com.vishal.appinventiv;

import com.vishal.appinventiv.entity.Movie;
import com.vishal.appinventiv.repository.MovieRepository;
import com.vishal.appinventiv.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppinventivApplicationTests {

    @Autowired
    private MovieService service;

    @MockBean
    private MovieRepository repository;

    @Test
    public void getMoviesTest(){

        when(repository.findAll()).thenReturn(Stream.of(
                new Movie(1, "Sherlock", "Web Series", 4),
                new Movie(2, "Shawshank Redemption", "Suspense", (float) 4.2))
                .collect(Collectors.toList()));
        assertEquals(2, service.getMovies().size());
    }

    @Test
    public void getMovieTest(){

        int id=1;
        when(repository.findById(id)).thenReturn(
                Optional.of(new Movie(1, "Sherlock", "Web Series", 4)));
        assertEquals(new Movie(1, "Sherlock", "Web Series", 4), service.getMovie(id));
    }

    @Test
    public void createMovieTest(){

        Movie movie = new Movie(3, "Swades", "Fiction - Revelation", (float) 4.5);
        when(repository.save(movie)).thenReturn(movie);
        assertEquals(movie, service.createMovie(movie));
    }

    @Test
    public void createMoviesTest(){

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(3, "Swades", "Fiction - Revelation", (float) 4.5));
        movies.add(new Movie(4, "Zindagi Milegi Na Dobara", "Life", (float) 3.3));

        when(repository.saveAll(movies)).thenReturn(movies);
        assertEquals(movies, service.createMovies(movies));
    }

    @Test
    public void deleteMovieTest(){

        Movie movie = new Movie(4, "Zindagi Milegi Na Dobara", "Life", (float) 3.3);
        repository.deleteById(movie.getId());
        assertEquals("Movie with the ID: 4 deleted from the List !!",
                service.deleteMovie(movie.getId()));
    }

    @Test
    public void updateMovieTest(){

        Movie movie = new Movie(4, "Swades", "Fiction - Revelation", (float) 4.5);
        Movie existingMovie = new Movie(4, "Zindagi Milegi Na Dobara", "Life", (float) 3.3);

        when(repository.findById(movie.getId())).thenReturn(Optional.of(existingMovie));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setCategory(movie.getCategory());
        existingMovie.setRating(movie.getRating());
        assertEquals(existingMovie, service.createMovie(existingMovie));
    }

}
