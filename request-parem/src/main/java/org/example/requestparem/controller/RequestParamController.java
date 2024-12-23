package org.example.requestparem.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }


//    @GetMapping("/show-info")
    public String showInfo(@RequestParam("name") String name) {
        return "Name: " + name ;
    }

    @GetMapping("/show-info")
    public String showInfo2(@RequestParam("name") String name,
                            @RequestParam("country") @Nullable String country,
                            HttpServletRequest request) {
        String experience = request.getParameter("experience");
        return "Name: " + name + ", country: " + country + ", experience: " + experience;
    }

    @GetMapping("/info/{name}")
    public String showInfo3(@PathVariable("name") String name){
        return "Name: " + name ;
    }
}
