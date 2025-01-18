package com.example.springapiexception.util;

import com.example.springapiexception.dto.EmployeeDto;
import com.example.springapiexception.entity.Employee;

public class EntityUtil {

    public static EmployeeDto getEmployeeDto(Employee emp) {
        return new EmployeeDto(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getSalary()
        );
    }

    public static Employee getEmployeeEntity(EmployeeDto employeeDto) {
        return new Employee(
                null,
                employeeDto.firstName(),
                employeeDto.lastName(),
                employeeDto.email(),
                employeeDto.salary()
        );
    }
}
