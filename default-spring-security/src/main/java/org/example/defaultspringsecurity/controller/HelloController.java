package org.example.defaultspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String home() {
        return "Home Page";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
