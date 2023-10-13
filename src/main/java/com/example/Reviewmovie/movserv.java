package com.example.Reviewmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class movserv {

    @Autowired
    private movrepo repository;

    public List<movies> findAllMovies() {
        return repository.findAll();
    }

    public Optional<movies> findMovieBymovieId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}