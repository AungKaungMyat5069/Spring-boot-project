package org.example.bookstoredemo.dao;

import org.example.bookstoredemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookDao extends JpaRepository<Book, Integer> {
}
