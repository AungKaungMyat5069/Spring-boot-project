package org.example.firstcupgraphql.controller;

import org.example.firstcupgraphql.ds.Employee;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    public List<Employee> employees;

    public EmployeeController() {
        employees = List.of(
                new Employee(1, "Aung", "Myat", 800.9, "Web developer"),
                new Employee(2, "John", "Doe", 700.9, "Human Resource"),
                new Employee(3, "Mary", "Lan", 750.9, "Graphic Designer"),
                new Employee(4, "Zaw", "Zaw", 999.9, "Team Lead"),
                new Employee(5, "Kyaw", "Kyaw", 600.9, "Tester")
        );
    }

    @QueryMapping //QueryMapping will  connect to type Query, one of the variable
    // But that variable name must equal with method name
    public List<Employee> findAllEmployees() {
        return employees;
    }

    @QueryMapping
    public Employee findEmployeeById(@Argument int id) {
        return employees.stream().filter(e -> e.id() == id).findFirst().orElse(null);
    }
}
