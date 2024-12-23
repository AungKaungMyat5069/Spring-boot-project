package org.example.employeecrudbackend;

import lombok.RequiredArgsConstructor;
import org.example.employeecrudbackend.dao.EmployeeDao;
import org.example.employeecrudbackend.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeCrudBackendApplication {

    private final EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCrudBackendApplication.class, args);
    }


    @Bean @Transactional
    @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            employeeDao.saveAll(
                    List.of(
                            new Employee(null, "John", "Doe", "johndoe@gmail.com", "777-88-999", LocalDate.now(), 800.99)
                            ,new Employee(null, "Jack", "Brain", "jackbrain@gmail.com", "777-88-992", LocalDate.now(), 900.99)
                            ,new Employee(null, "May", "U", "mayu@gmail.com", "777-88-993", LocalDate.now(), 750.99)
                            ,new Employee(null, "Asa", "Anta", "asaanta@gmail.com", "777-88-996", LocalDate.now(), 856.99)
                            ,new Employee(null, "Uka", "OO", "ukaoo@gmail.com", "777-88-995", LocalDate.now(), 800.99)
                    )
            );
        };
    }
}
