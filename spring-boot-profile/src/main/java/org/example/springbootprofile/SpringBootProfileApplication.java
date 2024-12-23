package org.example.springbootprofile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootProfileApplication {

    @Value("${app.name}")//just to declare
    private String appName;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("This is a :" +appName);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProfileApplication.class, args);
    }

}
