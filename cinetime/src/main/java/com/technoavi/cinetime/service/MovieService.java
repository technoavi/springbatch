package com.technoavi.cinetime.service;

import com.technoavi.cinetime.dao.model.Movie;
import com.technoavi.cinetime.dao.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).get();
    }

    public Movie getMovieByName(String name) {
        return movieRepository.findByMovieName(name);
    }

    private Movie copyMovie(Movie oldMovie, Movie newMovie) {
        oldMovie.setMovie_name(newMovie.getMovie_name());
        oldMovie.setActor(newMovie.getActor());
        oldMovie.setActress(newMovie.getActress());
        oldMovie.setDirector(newMovie.getDirector());
        oldMovie.setDescription(newMovie.getDescription());
        oldMovie.setRelease_date(newMovie.getRelease_date());

        return oldMovie;
    }

    public Movie updateMovieById(int id, Movie newMovie) {
        Movie oldMovie = movieRepository.findById(id).get();
        return movieRepository.save(copyMovie(oldMovie, newMovie));
    }

//    public Movie updateMovieByName() {
//      movieRepository
//    }

    public String deleteMovieById(int id) {
        movieRepository.deleteById(id);
        return "Movie deleted!!";
    }
}
