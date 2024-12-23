package org.example.bookstorebackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstorebackend.dto.BookInfo;
import org.example.bookstorebackend.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<BookInfo> getAllBooks() {
       return bookService.bookInfo();
    }
}
