package com.makinin.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<Movies>> getAllMovies() {
        return new ResponseEntity<List<Movies>>(moviesService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movies>> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movies>>(moviesService.singleMovie(id), HttpStatus.OK);
    }
}
