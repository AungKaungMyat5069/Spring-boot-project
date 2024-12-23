package org.example.studentmappingdemo.dao;

import org.example.studentmappingdemo.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectDao extends JpaRepository<StudentSubject, Integer> {
}
