package com.example.Reviewmovie;

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
@RequestMapping("/api/v1/movcont")
public class movcont {

    @Autowired
    private movserv service;

    @GetMapping
    public ResponseEntity<List<movies>> getMovies() {
        return new ResponseEntity<List<movies>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Optional<movies>> getSingleMovie(@PathVariable String movieId) {
        return new ResponseEntity<Optional<movies>>(service.findMovieBymovieId(movieId), HttpStatus.OK);
    }
}