package org.example.manytomany.dao;

import org.example.manytomany.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Integer> {
}
