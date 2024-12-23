package org.example.daoauthenticationprovider.dao;

import org.example.daoauthenticationprovider.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByName(String name);
}
