package org.example.bookstorebackend;

import lombok.RequiredArgsConstructor;
import org.example.bookstorebackend.dao.AuthorDao;
import org.example.bookstorebackend.dao.BookDao;
import org.example.bookstorebackend.dao.CategoryDao;
import org.example.bookstorebackend.entity.Address;
import org.example.bookstorebackend.entity.Author;
import org.example.bookstorebackend.entity.Book;
import org.example.bookstorebackend.entity.Category;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BookstoreBackendApplication {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final CategoryDao categoryDao;




    public static void main(String[] args) {
        SpringApplication.run(BookstoreBackendApplication.class, args);
    }



    @Bean @Transactional
//    @Profile("dev")
    public ApplicationRunner init() {
        return arg -> {
                    Category category1=new Category();
                    category1.setCategoryName("Novel");

                    Category category2=new Category();
                    category2.setCategoryName("History");

                    Author author1=new Author("Charles","Dicknes","charles@gmail.com",
                            "55-555-55",new Address("Dream Land","Landon","111111"));
                    Author author2=new Author("H.G","Wells","hgwells@gmail.com",
                            "55-555-56",new Address("Creek Bridge Road","Landon","222222"));

                    Book book1=new Book("Bleak House",54.4,"https://picsum.photos/id/237/200");
                    Book book2=new Book("A Tale of Two Cities",54.4,"https://picsum.photos/id/256/200");
                    Book book3=new Book("David Copperfield",54.4,"https://picsum.photos/id/258/200");
                    Book book4=new Book("World War 2",54.4,"https://picsum.photos/id/279/200");
                    Book book5=new Book("A Brief History of Human beings",54.4,"https://picsum.photos/id/290/200");
                    Book book6=new Book("Western History",54.4,"https://picsum.photos/id/345/200");


                    author1.addBook(book1);
                    author1.addBook(book2);
                    author1.addBook(book3);

                    author2.addBook(book4);
                    author2.addBook(book5);
                    author2.addBook(book6);

                    authorDao.save(author1);
                    authorDao.save(author2);

                    Category cat1=categoryDao.save(category1);
                    Category cat2=categoryDao.save(category2);

                    cat1.addBook(book1);
                    cat1.addBook(book2);
                    cat1.addBook(book3);

                    cat2.addBook(book4);
                    cat2.addBook(book5);
                    cat2.addBook(book6);

                    bookDao.save(book1);
                    bookDao.save(book2);
                    bookDao.save(book3);
                    bookDao.save(book4);
                    bookDao.save(book5);
                    bookDao.save(book6);
        };
    }
}
