package org.example.manytomany;

import lombok.RequiredArgsConstructor;
import org.example.manytomany.service.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication implements CommandLineRunner {

    private final MyService myService;

    @Override
    public void run(String... args) throws Exception {
        myService.createDb();
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from student_subjects");
    }

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }

}
