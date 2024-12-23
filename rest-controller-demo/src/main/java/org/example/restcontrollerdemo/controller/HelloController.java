package org.example.restcontrollerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    record Employee(int id, String name, int salary) {

    }

    @GetMapping("/")
    public List<Employee> hello() {
        return List.of(
                new Employee(1, "Aung", 200),
                new Employee(2, "Kaung", 220),
                new Employee(3, "Myat", 200)
        );
    }
}
