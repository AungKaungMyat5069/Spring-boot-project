package com.example.springapiexception.controller;

import com.example.springapiexception.dto.EmployeeDto;
import com.example.springapiexception.entity.Employee;
import com.example.springapiexception.exception.NamedAdminException;
import com.example.springapiexception.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create-employee")
    // @Valid is all in one, @Validation can be grouped and work as partition
    public EmployeeDto createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        if(employeeDto.firstName().equalsIgnoreCase("admin")) {
            throw  new NamedAdminException();
        }
        return employeeService.createEmployee(employeeDto);
    }
}
