package com.burak.moviereview.repository;

import com.burak.moviereview.models.Movies;
import com.burak.moviereview.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movies,String> {
    Optional<Movies> findByMovieName(String movieName);
    Optional<Movies> findMovieById(String id);

}
