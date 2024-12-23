package org.example.studentmappingdemo.dao;

import org.example.studentmappingdemo.ds.StudentInfo;
import org.example.studentmappingdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Integer> {

    @Query("""
select new org.example.studentmappingdemo.ds.StudentInfo(p.provinceName,s.firstName,s.lastName,stsub.marks,sub.subjectName) 
from Province p join p.students s 
join s.studentSubjects stsub join stsub.subject sub where sub.subjectName =:subjectName
and stsub.marks = (select max(sdsb.marks) from StudentSubject sdsb where sdsb.subject.subjectName =:subjectName)
""")
    Optional<StudentInfo> findStudentInfo(@Param("subjectName") String subjectName);
}
