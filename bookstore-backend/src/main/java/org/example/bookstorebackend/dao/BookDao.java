package org.example.bookstorebackend.dao;

import org.example.bookstorebackend.dto.BookInfo;
import org.example.bookstorebackend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

//    private Integer bookId;
//
//    private String title;
//    private Double price;
//    private String imgUrl;
//
//    private String categoryName;
//
//    private String firstName;
//    private String lastName;
//    private String email;

    @Query(
            """
    select new org.example.bookstorebackend.dto.BookInfo(
    b.id, b.title, b.price, b.imgUrl, c.categoryName, a.firstName, a.lastName, a.email
    )\s
    from Category c join c.books b join b.author a
"""
    )
    public List<BookInfo> bookInfo();
}
