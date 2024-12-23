package org.example.restapidemo.util;


import org.example.restapidemo.dto.EmployeeDto;
import org.example.restapidemo.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static EmployeeDto toEmployeeDto(Employee emp) {
        EmployeeDto empDto = new EmployeeDto();
        BeanUtils.copyProperties(emp, empDto);
        return empDto;
    }

    public static Employee toEmployeeEntity(EmployeeDto emp) {
        Employee empEntity = new Employee();
        BeanUtils.copyProperties(emp, empEntity);
        return empEntity;
    }
}
