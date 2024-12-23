package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Main {
    public static void main(String[] args) {

        //Inversion of Control (IoC)
        // Method 1
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("bean.xml");
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer);

        // BeanFactory is main root container
        // ApplicationContext is all in one

        // Method 1 (but that is in class path like resources or src)
//        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("bean.xml");
//        Customer customer2 = (Customer) context2.getBean("customer");
//        System.out.println(customer2);

        // Method 3 (most use)
        // Configuration annotation class and bean annotation
        // Configuration will class and bean will be configuration of method
        // what is bean? bean is that object change to bean managed by Spring
        // ApplicationContext is bag collection that has many beans
    }
}