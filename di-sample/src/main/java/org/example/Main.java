package org.example;

import org.example.info.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        //Dependency Injection with xml file
//        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("depend.xml");
//        context.registerShutdownHook();
//        Person person = context.getBean("person", Person.class);
//        System.out.println(person);

        //Dependency Injection with @Configuration annotation
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}