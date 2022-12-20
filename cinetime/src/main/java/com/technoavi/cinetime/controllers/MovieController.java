package com.technoavi.cinetime.controllers;

import com.technoavi.cinetime.dao.model.Movie;
import com.technoavi.cinetime.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie") // localhost:8080/movie
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/save") // localhost:8080/movie/save
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/getjson") // localhost:8080/movie/getjson
    public Movie getMovieJson() {
        return new Movie();
    }

    @GetMapping("/getall") // localhost:8080/movie/getall
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/getbyid/{id}") // localhost:8080/movie/getbyid/{id}
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/getbyname/{name}") // localhost:8080/movie/getbyname/{name}
    public Movie getMovieByName(@PathVariable String name) {
        return movieService.getMovieByName(name);
    }

    @PutMapping("/updatebyid/{id}") // localhost:8080/movie/updatebyid/{id}
    public Movie updateMovieById(@PathVariable int id, @RequestBody Movie newMovie) {
        return movieService.updateMovieById(id, newMovie);
    }

//    public Movie updateMovieByName() {
//      movieService
//    }

    @DeleteMapping("/deletebyid/{id}") // localhost:8080/movie/deletebyid/{id}
    public String deleteMovieById(@PathVariable int id) {
        movieService.deleteMovieById(id);
        return "Movie deleted!!";
    }
}
