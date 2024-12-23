package org.example.employeecrudbackend.dao;

import org.example.employeecrudbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
