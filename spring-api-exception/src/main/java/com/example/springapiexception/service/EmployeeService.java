package com.example.springapiexception.service;

import com.example.springapiexception.dao.EmployeeDao;
import com.example.springapiexception.dto.EmployeeDto;
import com.example.springapiexception.util.EntityUtil;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return EntityUtil.getEmployeeDto(employeeDao.save(EntityUtil.getEmployeeEntity(employeeDto)));
    }
}
