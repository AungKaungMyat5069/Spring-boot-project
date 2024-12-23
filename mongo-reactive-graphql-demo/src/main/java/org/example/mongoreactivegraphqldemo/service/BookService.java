package org.example.mongoreactivegraphqldemo.service;

import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphqldemo.dao.BookDao;
import org.example.mongoreactivegraphqldemo.dto.BookDto;
import org.example.mongoreactivegraphqldemo.entity.Book;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;

    public Flux<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Mono<Book> getBookById(String  id) {
        return bookDao.findById(id);
    }

    public Mono<Book> createBook(BookDto bookDto) {
        Book book = new Book(bookDto.id(), bookDto.title(), bookDto.author());
        return bookDao.save(book);
    }

    public Mono<Boolean> deleteBook(String id) {
        return bookDao.deleteById(id).hasElement();
    }

    public Mono<Book> updateBook(String id, BookDto bookDto) {
        Book book = new Book(null, bookDto.title(), bookDto.author());
        return bookDao.findById(id)
                .flatMap(j -> Mono.just(book).doOnNext(bo -> bo.setId(id)))
                .flatMap(bookDao::save);
    }
}
