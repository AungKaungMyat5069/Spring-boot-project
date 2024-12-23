package org.example.studentmappingdemo.service;

import lombok.RequiredArgsConstructor;
import org.example.studentmappingdemo.dao.ProvinceDao;
import org.example.studentmappingdemo.dao.StudentDao;
import org.example.studentmappingdemo.dao.StudentSubjectDao;
import org.example.studentmappingdemo.dao.SubjectDao;
import org.example.studentmappingdemo.entity.Province;
import org.example.studentmappingdemo.entity.Student;
import org.example.studentmappingdemo.entity.StudentSubject;
import org.example.studentmappingdemo.entity.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;
    private final ProvinceDao provinceDao;
    private final StudentSubjectDao studentSubjectDao;
    private final SubjectDao subjectDao;

    @Transactional
    public void createSql() {
            Province province1 = new Province();
            province1.setProvinceName("Sule");

            Province province2 = new Province();
            province2.setProvinceName("NO");

            Province province3 = new Province();
            province3.setProvinceName("Haling");

            Student student1 = new Student("John","Doe","john@gmail.com","ISM");
            Student student2 = new Student("John","William","william@gmail.com","ISM");
            Student student3 = new Student("John","Updike","updike@gmail.com","ISY");
            Student student4 = new Student("Charles","Dickens","dickens@gmail.com","ISY");
            Student student5 = new Student("Thomas","Hardy","hardy@gmail.com","PISM");
            Student student6 = new Student("Harkuri","Murakami","murakami@gmail.com","ISM");

            Subject subject1 = new Subject("Java",2000,6);
            Subject subject2 = new Subject("Python",2500,6);
            Subject subject3 = new Subject("PHP",2500,6);
            Subject subject4 = new Subject("JavaScript",2500,6);

            //mapping
            province1.addStudent(student1);
            province1.addStudent(student2);

            province2.addStudent(student3);
            province2.addStudent(student4);

            province3.addStudent(student5);
            province3.addStudent(student6);
            // student 1 - java - 90

            StudentSubject studentSubject1=new StudentSubject();
            studentSubject1.setMarks(90);
            student1.addStudentSubject(studentSubject1);
            subject1.addStudentSubject(studentSubject1);
            // student 1 - Python - 80
            StudentSubject studentSubject2=new StudentSubject();
            studentSubject2.setMarks(80);
            student1.addStudentSubject(studentSubject2);
            subject2.addStudentSubject(studentSubject2);
            //student 1 - JavaScript - 95
            StudentSubject studentSubject3=new StudentSubject();
            studentSubject3.setMarks(95);
            student1.addStudentSubject(studentSubject3);
            subject4.addStudentSubject(studentSubject3);

            //student 2 - java - 95
            StudentSubject studentSubject4=new StudentSubject();
            studentSubject4.setMarks(95);
            student2.addStudentSubject(studentSubject4);
            subject1.addStudentSubject(studentSubject4);

            //student 3 - java - 80
            StudentSubject studentSubject5=new StudentSubject();
            studentSubject5.setMarks(80);
            student3.addStudentSubject(studentSubject5);
            subject1.addStudentSubject(studentSubject5);

            // student 4 - PHP - 80
            StudentSubject studentSubject6=new StudentSubject();
            studentSubject6.setMarks(80);
            student4.addStudentSubject(studentSubject6);
            subject3.addStudentSubject(studentSubject6);

            //student 5 - java - 75
            StudentSubject studentSubject7=new StudentSubject();
            studentSubject7.setMarks(75);
            student5.addStudentSubject(studentSubject7);
            subject1.addStudentSubject(studentSubject7);

            //student 6 - java - 85
            StudentSubject studentSubject8=new StudentSubject();
            studentSubject8.setMarks(85);
            student6.addStudentSubject(studentSubject8);
            subject1.addStudentSubject(studentSubject8);

            provinceDao.save(province1);
            provinceDao.save(province2);
            provinceDao.save(province3);

            subjectDao.save(subject1);
            subjectDao.save(subject2);
            subjectDao.save(subject3);
            subjectDao.save(subject4);


    }

}
