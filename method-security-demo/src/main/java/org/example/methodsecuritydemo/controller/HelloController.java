package org.example.methodsecuritydemo.controller;

import org.example.methodsecuritydemo.ds.Employee;
import org.example.methodsecuritydemo.service.BookService;
import org.example.methodsecuritydemo.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final NameService nameService;
    private final BookService bookService;

    public HelloController(NameService nameService, BookService bookService) {
        this.nameService = nameService;
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public  String getHello() {
        return nameService.getName();
    }

    @GetMapping("/secret/{name}")
    public List<String> getSecret(@PathVariable(name = "name") String name) {
        return nameService.getSecretName(name);

    }

    @GetMapping("/book/{name}")
    public Employee addEmployee(@PathVariable("name") String name) {
       return bookService.getEmployees(name);
    }
}
