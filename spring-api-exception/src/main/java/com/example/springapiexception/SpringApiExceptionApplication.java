package com.example.springapiexception;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiExceptionApplication.class, args);
    }


    public ApplicationRunner runner() {
        return args -> {
            System.out.println("Hello World");
        };
    }
}
