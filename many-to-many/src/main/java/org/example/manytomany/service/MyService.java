package org.example.manytomany.service;

import lombok.RequiredArgsConstructor;
import org.example.manytomany.dao.StudentDao;
import org.example.manytomany.dao.SubjectDao;
import org.example.manytomany.entity.Student;
import org.example.manytomany.entity.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyService {

    private final StudentDao studentDao;
    private final SubjectDao subjectDao;

    @Transactional
    public void createDb() {
        Student student1 = new Student("Aung", "Aung", "aung@gmail.com","Bo6");
        Student student2 = new Student("Kaung", "Kaung", "kaung@gmail.com","Bo6");
        Student student3 = new Student("Mike", "Mike", "mike@gmail.com","Bo6");
        Student student4 = new Student("Jack", "Jack", "jack@gmail.com","Bo6");
        Student student5 = new Student("Zaw", "Zaw", "zaw@gmail.com","Bo6");
        Student student6 = new Student("Su", "Su", "su@gmail.com","Bo6");

        Subject subject1 = new Subject("Java", 6, 200);
        Subject subject2 = new Subject("Python", 6, 200);
        Subject subject3 = new Subject("JavaScript", 6, 200);

        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject3);

        student2.addSubject(subject2);
        student2.addSubject(subject3);

        student3.addSubject(subject1);
        student3.addSubject(subject2);


        student4.addSubject(subject2);

        student5.addSubject(subject1);
        student5.addSubject(subject3);

        student6.addSubject(subject2);
        student6.addSubject(subject3);

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
        studentDao.save(student4);
        studentDao.save(student5);
        studentDao.save(student6);
    }
}
