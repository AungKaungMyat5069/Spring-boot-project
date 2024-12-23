package org.example.methodsecuritydemo.service;


import org.example.methodsecuritydemo.ds.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Employee> employees =
            Map.of(
                    "john", new Employee(
                            "John William"
                            , List.of("Karamazov Brothers")
                            , List.of("reader", "writer")
                    ),
                    "mary", new Employee(
                            "Mary Shelley"
                            , List.of("Hundred Years of Sollitude")
                            , List.of("write", "checker")
                    )
            );

    //Post Authorize -- have return Object meant returner
    // returnObject may be Employee that can used like java
    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getEmployees(String name) {
        return employees.get(name);
    }
}
