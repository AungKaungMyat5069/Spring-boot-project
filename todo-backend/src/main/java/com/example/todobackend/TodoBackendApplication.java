package com.example.todobackend;

import com.example.todobackend.dao.UserDao;
import com.example.todobackend.entity.Role;
import com.example.todobackend.entity.Users;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TodoBackendApplication {

    private final UserDao users;

    private final PasswordEncoder passwordEncoder;

    public TodoBackendApplication(UserDao users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(TodoBackendApplication.class, args);
    }


    @Bean @Profile("dev")
    public ApplicationRunner init() {
        return args -> {
            Users john = new Users(null,"john", "john@gmail.com", passwordEncoder.encode("111"));
            Users mary = new Users(null, "mary", "mary@gmail.com", passwordEncoder.encode("111"));
            Role admin = new Role(null, "ROLE_ADMIN");
            Role staff = new Role( null , "ROLE_STAFF");
            john.addRole(admin);
            mary.addRole(staff);
            users.save(john);
            users.save(mary);
        };
    }
}
