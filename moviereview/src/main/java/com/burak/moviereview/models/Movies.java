package com.burak.moviereview.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "Movies")
public class Movies {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String movieName;
    private String genre;
    private String director;
    private double rating;
    private Date releaseDate;

    public Movies() {
    }

    public Movies(String id, String movieName, String genre, String director, double rating, Date releaseDate) {
        this.id = id;
        this.movieName = movieName;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public Movies(String movieName, String genre, String director, double rating, Date releaseDate) {
        this.movieName = movieName;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
