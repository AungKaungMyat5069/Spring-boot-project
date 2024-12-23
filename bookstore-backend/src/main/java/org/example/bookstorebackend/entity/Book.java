package org.example.bookstorebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Book extends IdClass {

    private String title;
    private Double price;
    private String imgUrl;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    public Book(String title, Double price, String imgUrl) {
        this.title = title;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
