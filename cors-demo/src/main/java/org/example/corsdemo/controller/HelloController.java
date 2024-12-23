package org.example.corsdemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin("*")
public class HelloController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/")
    public String hello() {
        return "hello.html";
    }

    @PostMapping("/hello")
    @ResponseBody
//    @CrossOrigin("http://localhost:8080")
    public String helloPost() {
        logger.info("hello post");
        return "hello post";

    }
}
