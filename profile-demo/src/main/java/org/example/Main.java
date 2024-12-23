package org.example;

import org.example.service.ComplexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Method One
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.register(AppConfig.class);
        context.getEnvironment().setActiveProfiles("db");
        context.refresh();

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.registerShutdownHook();
//
//        ComplexService service = context.getBean(ComplexService.class);
//        service.doAction();

        // @Component or @Bean that have with @Profile work after normal @component
        // can run like click main run function and configure run and change enviorment
        //-Dspring.profiles.active=db
    }
}