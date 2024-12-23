package org.example.authrizedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/task")
    public String task() {
        return "I'm a task";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
