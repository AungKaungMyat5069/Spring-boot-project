package org.example.mongoreactivegraphqldemo;

import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphqldemo.dao.BookDao;
import org.example.mongoreactivegraphqldemo.entity.Book;
import org.example.mongoreactivegraphqldemo.entity.Review;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class MongoReactiveGraphqlDemoApplication {

    private final BookDao bookDao;
    @Bean
    @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            Book book = new Book(null, "A Tale of Two city","Charles Dickens");
            Book book1 = new Book(null, "Return of the Native", "Thomas Handy");
            book.addReview(new Review("two cities", "a good novel"));
            book.addReview(new Review("two cities", "two Thumps UP"));
            book1.addReview(new Review("return of native", "Excellent"));

            bookDao.save(book).subscribe();
            bookDao.save(book1).subscribe();
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(MongoReactiveGraphqlDemoApplication.class, args);
    }

}
