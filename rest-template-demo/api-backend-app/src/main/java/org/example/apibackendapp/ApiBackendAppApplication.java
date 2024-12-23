package org.example.apibackendapp;

import lombok.RequiredArgsConstructor;
import org.example.apibackendapp.dao.CustomerDao;
import org.example.apibackendapp.entity.Customer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ApiBackendAppApplication {

    private final CustomerDao customerDao;

    @Bean
    @Transactional
    @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            customerDao.saveAll(List.of(
                    new Customer("John", "Doe", "john@gmail.com", "111-222-3333"),
                    new Customer("Mary", "Sam", "mary@gmail.com", "111-222-3331"),
                    new Customer("Jack", "Smith", "jack@gmail.com", "111-222-3332"),
                    new Customer("Su", "Su", "su@gmail.com", "111-222-3334"),
                    new Customer("Aung", "Aung", "aung@gmail.com", "111-222-3335")
            ));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiBackendAppApplication.class, args);
    }

}
