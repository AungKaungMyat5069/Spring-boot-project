package org.example.bookstorebackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author extends IdClass {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @Embedded
    private Address address;

    public Author(String firstName, String lastName, String email, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void addBook(Book book) {
        book.setAuthor(this);
        this.books.add(book);
    }
}
