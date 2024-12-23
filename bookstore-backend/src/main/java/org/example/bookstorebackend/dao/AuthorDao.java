package org.example.bookstorebackend.dao;

import org.example.bookstorebackend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {
}
