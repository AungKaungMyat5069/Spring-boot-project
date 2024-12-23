package org.example.bookstoredemo;

import lombok.RequiredArgsConstructor;
import org.example.bookstoredemo.dao.AuthorDao;
import org.example.bookstoredemo.entity.Author;
import org.example.bookstoredemo.entity.Book;
import org.example.bookstoredemo.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@RequiredArgsConstructor
public class BookStoreDemoApplication  {

    private final BookService bookService;
    private final AuthorDao authorDao;


    @Bean @Transactional @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            Author author1 = new Author("Eiichiro", "Oda",
                    LocalDate.of(1975, Month.JANUARY, 1),
                    "oda@gmail.com", "55-444-55");
            Author author2 = new Author("Masashi", "Kishimoto",
                    LocalDate.of(1974, Month.NOVEMBER,8),
                    "kishimoto@gmail.com", "55-444-56");
            Author author3 = new Author("Akira", "Toriyama",
                    LocalDate.of(1955, Month.APRIL, 5),
                    "toriyama@gmail.com", "55-444-57");

//            July 22, 1997
            Book book1 = new Book("One Piece", "https://wallpapercave.com/wp/wp7538386.jpg",
                    8.99, "Pirate",
                    LocalDate.of(1997, Month.JULY,22));
//            May 4, 2010
            Book book2 = new Book("One Piece", "https://static.wikia.nocookie.net/onepiece/images/d/d2/Volume_44.png/revision/latest?cb=20221230202513",
                    8.99, "Pirate",
                    LocalDate.of(2010, Month.MAY,4));

//            September 21, 1999
            Book book3 = new Book("Naruto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQEHFGHu6R-VMZvra4Mn98iuv3xwgbzpn__Q&s",
                    8.99, "Ninja",
                    LocalDate.of(1999, Month.SEPTEMBER,21));
//            May 2, 2012
            Book book4 = new Book("Naruto Shippuden", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgckaHHHvjltAFMCrEXDyU3NuyvcGu10DW3Q&s",
                    8.99, "Ninja",
                    LocalDate.of(2012, Month.MAY,2));
//           April 26, 1989
            Book book5 = new Book("Dragon Ball Z", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiqx1o78s4QYbgn_NRjKjvuKHP-aQfCb2ztg&s",
                    8.99, "Dragon Ball",
                    LocalDate.of(1989, Month.APRIL,26));
            Book book6 = new Book("Dragon Ball Z", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb7GIsvTJuVCKCDj0wedQRIuINHusUOfd2Sg&s",
                    8.99, "Dragon Ball",
                    LocalDate.of(2003, Month.JANUARY,10));

            author1.addBook(book1);
            author1.addBook(book2);
            author2.addBook(book3);
            author2.addBook(book4);
            author3.addBook(book5);
            author3.addBook(book6);

            authorDao.save(author1);
            authorDao.save(author2);
            authorDao.save(author3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreDemoApplication.class, args);
    }

}
