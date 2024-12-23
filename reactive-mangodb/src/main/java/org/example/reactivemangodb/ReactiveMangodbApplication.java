package org.example.reactivemangodb;

import lombok.RequiredArgsConstructor;
import org.example.reactivemangodb.dao.ProductDao;
import org.example.reactivemangodb.entity.Product;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor

public class ReactiveMangodbApplication {

    private final ProductDao productDao;

    @Bean @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            Product apple = new Product(null,"apple", "to eat", 29.9);
            Product orange = new Product(null,"orange", "to eat", 28.9);
            Product banana = new Product(null,"banana", "to eat", 29.9);

            productDao.save(apple).subscribe();
            productDao.save(orange).subscribe();
            productDao.save(banana).subscribe();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMangodbApplication.class, args);
    }

}
