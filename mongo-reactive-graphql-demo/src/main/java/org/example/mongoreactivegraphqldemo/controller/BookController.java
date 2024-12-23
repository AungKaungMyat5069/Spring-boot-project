package org.example.mongoreactivegraphqldemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphqldemo.dto.BookDto;
import org.example.mongoreactivegraphqldemo.entity.Book;
import org.example.mongoreactivegraphqldemo.service.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Mono<Book> getBookById(@Argument String  id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Mono<Book> createBook(@Argument("book") BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @MutationMapping
    public Mono<Boolean> deleteById(@Argument String  id) {
        return bookService.deleteBook(id).defaultIfEmpty(false);
    }

    @MutationMapping
    public Mono<Book> updateBook(@Argument String id, @Argument BookDto book) {
        return bookService.updateBook(id, book);
    }
}
