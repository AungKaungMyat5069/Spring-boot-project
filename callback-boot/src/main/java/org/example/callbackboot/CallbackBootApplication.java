package org.example.callbackboot;

import lombok.RequiredArgsConstructor;
import org.example.callbackboot.service.EmployeeClientService;
import org.example.callbackboot.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CallbackBootApplication implements CommandLineRunner {

//    private final EmployeeService employeeService;
    private final EmployeeClientService employeeClientService;

    public static void main(String[] args) {
        SpringApplication.run(CallbackBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeClientService.doAction();
    }
}
