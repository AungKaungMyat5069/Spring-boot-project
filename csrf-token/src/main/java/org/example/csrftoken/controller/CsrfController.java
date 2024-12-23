package org.example.csrftoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    @GetMapping("/hello")
    public String hello() {

        return "Hello World";
    }

    //2, curl -X POST url // call post in security will not work in spring boot
    // cuz it will defend csrf
    @PostMapping("/hello")
    public String helloPost() {
        return "Hello World";
    }
}
