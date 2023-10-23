package com.burak.moviereview.controllers;

import com.burak.moviereview.Service.MoviesService;
import com.burak.moviereview.dto.MoviesDto;
import com.burak.moviereview.models.Movies;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private MoviesService moviesService;


    public MovieController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return new ResponseEntity<>(moviesService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok(moviesService.getMovieById(id));

    }

    @PostMapping("/create")
    public void addNewMovie(@RequestBody Movies movies) {

        moviesService.addNewMovie(movies);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Void> updateMovie(@PathVariable String id,@RequestBody Movies movies) {
        movies.setId(id);
        moviesService.updateMovie(movies);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/delete")
    public void deleteMovie(@PathVariable String id){
        moviesService.deleteMovie(id);
        return ;
    }
}
