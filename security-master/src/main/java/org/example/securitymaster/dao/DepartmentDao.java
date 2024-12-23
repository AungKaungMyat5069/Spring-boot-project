package org.example.securitymaster.dao;

import org.example.securitymaster.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
