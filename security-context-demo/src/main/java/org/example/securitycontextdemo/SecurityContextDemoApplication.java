package org.example.securitycontextdemo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

// synchronize - racing problem -thread safe
@SpringBootApplication
@EnableAsync
public class SecurityContextDemoApplication {


    @Bean
    public InitializingBean initializingBean() {
        return () -> {
            SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityContextDemoApplication.class, args);
    }

}
