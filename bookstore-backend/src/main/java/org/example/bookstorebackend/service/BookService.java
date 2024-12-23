package org.example.bookstorebackend.service;

import lombok.RequiredArgsConstructor;
import org.example.bookstorebackend.dao.BookDao;
import org.example.bookstorebackend.dto.BookInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public List<BookInfo> bookInfo() {
        return bookDao.bookInfo();
    }
}
