package org.example.restapidemo.dao;

import org.example.restapidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {


}
