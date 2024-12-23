package org.example.studentmappingdemo;

import lombok.RequiredArgsConstructor;
import org.example.studentmappingdemo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentMappingDemoApplication implements CommandLineRunner {

    private final StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        studentService.createSql();
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student_subject");
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentMappingDemoApplication.class, args);
    }

}
