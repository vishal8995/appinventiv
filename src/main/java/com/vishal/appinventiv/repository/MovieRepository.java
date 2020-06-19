package com.vishal.appinventiv.repository;

import com.vishal.appinventiv.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
