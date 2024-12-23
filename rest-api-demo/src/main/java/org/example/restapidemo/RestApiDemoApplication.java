package org.example.restapidemo;

import lombok.RequiredArgsConstructor;
import org.example.restapidemo.dao.EmployeeDao;
import org.example.restapidemo.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class RestApiDemoApplication {
    private final EmployeeDao employeeDao;

    @Bean
    @Transactional @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            Employee john = new Employee(null, "john", "London", "990099", "john@gmail.com");
            Employee mary = new Employee(null, "mary", "Sweden", "990029", "mary@gmail.com");
            Employee kevin = new Employee(null, "kevin", "New York", "990093", "kevin@gmail.com");

            employeeDao.save(john);
            employeeDao.save(mary);
            employeeDao.save(kevin);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApiDemoApplication.class, args);
    }

}
