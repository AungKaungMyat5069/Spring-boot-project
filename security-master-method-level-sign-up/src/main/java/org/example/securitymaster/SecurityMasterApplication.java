package org.example.securitymaster;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.RoleDao;
import org.example.securitymaster.dao.UserDao;
import org.example.securitymaster.security.ds.Role;
import org.example.securitymaster.security.ds.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityMasterApplication {
    private final PasswordEncoder passwordEncoder;
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Bean
    @Transactional @Profile("dev")
    public ApplicationRunner init() {

        return args -> {
//            Role admin = new Role("ROLE_SUPER_ADMIN");
//            User john = new User("john", passwordEncoder.encode("john"));
//            john.addRole(admin);
//            userDao.save(john);

            Role employeeAdmin = new Role("ROLE_EMPLOYEES_ADMIN");
            User emma = new User("emma", passwordEncoder.encode("emma"));
            emma.addRole(employeeAdmin);

            Role departmentPageView = new Role("ROLE_DEPARTMENTS_PAG_VIEW");
            Role departmentRead = new Role("ROLE_DEPARTMENTS_READ");
            Role departmentCreate = new Role("ROLE_DEPARTMENTS_CREATE");
            User william = new User("william", passwordEncoder.encode("william"));
            william.addRole(departmentPageView);
            william.addRole(departmentRead);
            william.addRole(departmentCreate);

            Role customerPageView = new Role("ROLE_CUSTOMERS_PAG_VIEW");
            Role customerRead = new Role("ROLE_CUSTOMERS_READ");
            User lucas = new User("lucas", passwordEncoder.encode("lucas"));
            lucas.addRole(customerPageView);
            lucas.addRole(customerRead);

            User tom = new User("tom", passwordEncoder.encode("tom"));

            userDao.save(emma);
            userDao.save(william);
            userDao.save(lucas);
            userDao.save(tom);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityMasterApplication.class, args);
    }

}
