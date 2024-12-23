package org.example.myautoconfigdemo;

import org.example.fileStore.FileStore;
import org.example.myautoconfigdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAutoconfigDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private FileStore fileStore;



    public static void main(String[] args) {
        SpringApplication.run(MyAutoconfigDemoApplication.class, args);
    }

    @Override
//    @Bean
    public void run(String... args) throws Exception {
        fileStore.fileStore();
        employeeDao.allEmployees().forEach(System.out::println);
    }
}
