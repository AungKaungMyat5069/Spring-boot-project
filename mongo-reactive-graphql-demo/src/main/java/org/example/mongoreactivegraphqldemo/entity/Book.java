package org.example.mongoreactivegraphqldemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Document
public class Book {

    @Id
    private String id;
    private String title;
    private String author;

    private List<Review> reviews = new ArrayList<>();

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
