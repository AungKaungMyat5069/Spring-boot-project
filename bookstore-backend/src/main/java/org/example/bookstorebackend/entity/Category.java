package org.example.bookstorebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass {
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        book.setCategory(this);
        this.books.add(book);
    }
}
