package com.example.Reviewmovie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface movrepo extends MongoRepository<movies, ObjectId> {
    Optional<movies> findMovieByImdbId(String movieId);
}