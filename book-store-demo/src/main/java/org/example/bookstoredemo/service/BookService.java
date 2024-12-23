package org.example.bookstoredemo.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstoredemo.dao.AuthorDao;
import org.example.bookstoredemo.dao.BookDao;
import org.example.bookstoredemo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getBookById(int id) {
        return bookDao.findById(id).orElse(null);
    }
}
