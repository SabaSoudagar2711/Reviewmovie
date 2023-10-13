package com.example.Reviewmovie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface revrepo extends MongoRepository<reviewIt, ObjectId> {
}
