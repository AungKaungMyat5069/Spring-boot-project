package org.example.connectiondemo;

import lombok.RequiredArgsConstructor;
import org.example.connectiondemo.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ConnectionDemoApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.withTransaction();
    }
}
