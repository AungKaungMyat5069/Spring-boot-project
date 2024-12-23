package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Method 2 writing
// 1. add to Configuration on class
// 2. add to method that you want to ioc with @Bean
@Configuration
public class AppConfigMethod2 {

    @Bean
    public Customer customer() {
        return new Customer("Aung Myat", 15);
    }
}
