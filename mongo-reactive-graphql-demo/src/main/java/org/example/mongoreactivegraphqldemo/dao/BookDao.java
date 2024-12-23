package org.example.mongoreactivegraphqldemo.dao;

import org.example.mongoreactivegraphqldemo.entity.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookDao extends ReactiveMongoRepository<Book, String> {
}
