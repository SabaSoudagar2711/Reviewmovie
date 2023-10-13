package com.example.Reviewmovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class movies {
    @Id
    private ObjectId id;
    private String movieId;
    private String title;
    private String language;
    private String yearReleased;
    private String story;
    private String trailerLink;
    private String movieFlyer;
    private List<String> backdrops;
    private List<String> genres;
    @DocumentReference
    private List<reviewIt> reviewIds;
    private List<ratings> rating;

    public movies(String movieId, String title, String language, String yearReleased, String story, String trailerLink, String movieFlyer, List<String> backdrops, List<String> genres) {
        this.movieId = movieId;
        this.title = title;
        this.yearReleased = yearReleased;
        this.trailerLink = trailerLink;
        this.movieFlyer = movieFlyer;
        this.backdrops = backdrops;
        this.genres = genres;
    }
}
