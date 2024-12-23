package org.example.bookstoredemo.dao;


import org.example.bookstoredemo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {
}
