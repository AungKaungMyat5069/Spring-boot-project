package org.example;

import org.example.bean.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Application Context close method
        // close
        // try closeable
        // registerShutdownHook(recommended)

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCofig.class);
        context.registerShutdownHook();
        SpringBean1 bean = context.getBean(SpringBean1.class);
        bean.greet("Aung Kaung Myat");

    }
}