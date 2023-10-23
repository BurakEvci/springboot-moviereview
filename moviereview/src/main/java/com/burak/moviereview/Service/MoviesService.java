package com.burak.moviereview.Service;

import com.burak.moviereview.Service.MoviesService;
import com.burak.moviereview.dto.MoviesDto;
import com.burak.moviereview.models.Movies;
import com.burak.moviereview.exceptions.MovieNotFoundException;
import com.burak.moviereview.models.Movies;
import com.burak.moviereview.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    private final MovieRepository movieRepository;


    public MoviesService(MovieRepository movieRepository ) {
        this.movieRepository = movieRepository;

    }

    public List<Movies> getAllMovies() {

        return movieRepository.findAll(); // Tüm filmleri veritabanından getir
    }

//    public Movies findMovieById(String id) {
//        return movieRepository.findMovieById(id).orElseThrow(
//                () -> new MovieNotFoundException("Movie could not find by id: " + id));
//    }

    public Optional<Movies> getMovieById(String id) {
        return movieRepository.findMovieById(id);
    }



//    public Movies addMovie(String movieName, String genre, String director, double rating, Date releaseDate) {
//        Movies movie = new Movies(movieName, genre, director, rating, releaseDate);
        // Veritabanına yeni film eklemek için kullanılabilecek kodu burada yazın
        // Örneğin:
        // movieRepository.save(movie);
//        return movieRepository.save(movie);
//    }

    public void addNewMovie(Movies movies) {
        Optional<Movies> moviesOptional = movieRepository
                .findMovieById(movies.getId());
        if (moviesOptional.isPresent()) {
            throw new IllegalStateException("movie could not created");
        }
        movieRepository.save(movies);
    }

    public void updateMovie(Movies movies) {
        movieRepository.save(movies);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
