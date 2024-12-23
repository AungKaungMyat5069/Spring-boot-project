package org.example.studentmappingdemo.dao;

import org.example.studentmappingdemo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Integer> {
}
