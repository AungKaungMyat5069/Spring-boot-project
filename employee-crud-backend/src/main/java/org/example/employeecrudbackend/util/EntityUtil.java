package org.example.employeecrudbackend.util;

import org.example.employeecrudbackend.dto.EmployeeDto;
import org.example.employeecrudbackend.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static Employee toEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }

    public static EmployeeDto toDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }
}
