package org.example.bookstoredemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String imgUrl;
    private double price;
    private String genre;
    private LocalDate publishDate;

    @ManyToOne
    private Author author;

    public Book(String title, String imgUrl, double price, String genre, LocalDate publishDate) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.price = price;
        this.genre = genre;
        this.publishDate = publishDate;
    }
}
