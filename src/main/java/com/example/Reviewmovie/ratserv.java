package com.example.Reviewmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ratserv {
    @Autowired
    private raterepo repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ratings createrating(String ratingBody, String movieId) {
        ratings rating = repository.insert(new ratings(ratingBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(movies.class)
                .matching(Criteria.where("movieId").is(movieId))
                .apply(new Update().push("ratings").value(rating))
                .first();

        return rating;
    }
}
