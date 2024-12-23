package org.example.daoauthenticationprovider;

import lombok.RequiredArgsConstructor;
import org.example.daoauthenticationprovider.dao.EmployeeDao;
import org.example.daoauthenticationprovider.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class DaoAuthenticationProviderApplication {

    private final EmployeeDao employeeDao;
    private final PasswordEncoder passwordEncoder;

    @Bean @Transactional @Profile("dev")
    public ApplicationRunner init() {

        return args -> {

            Employee employee1 = new Employee("john","john@gmail.com", "44-555-56", passwordEncoder.encode("12345"), "admin");
            Employee employee2 = new Employee("mary", "mary@gmail.com", "44-555-56", passwordEncoder.encode("12345"), "user");

            employeeDao.save(employee1);
            employeeDao.save(employee2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DaoAuthenticationProviderApplication.class, args);
    }

}
