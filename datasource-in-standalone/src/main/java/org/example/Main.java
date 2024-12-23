package org.example;

import org.example.dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        context.registerShutdownHook();

        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        employeeDao.findEmail().forEach(System.out::println);
    }
}