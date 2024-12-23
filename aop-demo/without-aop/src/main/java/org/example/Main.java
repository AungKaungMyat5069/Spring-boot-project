package org.example;

import org.example.service.ComplexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ComplexService complexService = (ComplexService) context.getBean("complexService");

        complexService.doAction();
    }
}