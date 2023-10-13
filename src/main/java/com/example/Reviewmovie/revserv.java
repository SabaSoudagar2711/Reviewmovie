package com.example.Reviewmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class revserv {
    @Autowired
    private revrepo repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public reviewIt createReview(String reviewBody, String movieId) {
        reviewIt review = repository.insert(new reviewIt(reviewBody, LocalDateTime.now(), LocalDateTime.now()));


        mongoTemplate.update(movies.class)
                .matching(Criteria.where("movieId").is(movieId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}