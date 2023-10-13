package com.example.Reviewmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class revcont {
    @Autowired
    private revserv service;

    @PostMapping()
    public ResponseEntity<reviewIt> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<reviewIt>(service.createReview(payload.get("reviewBody"), payload.get("movieId")),
                HttpStatus.OK);
    }
}