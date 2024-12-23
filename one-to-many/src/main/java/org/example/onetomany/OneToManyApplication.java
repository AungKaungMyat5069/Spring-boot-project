package org.example.onetomany;

import lombok.RequiredArgsConstructor;
import org.example.onetomany.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToManyApplication implements CommandLineRunner {

    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        productService.createdb();
        JPAUtil.checkData("select * from Product");
        JPAUtil.checkData("select * from Category");
    }

    public static void main(String[] args) {
        SpringApplication.run(OneToManyApplication.class, args);
    }

}
