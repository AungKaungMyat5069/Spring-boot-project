package org.example.reactivedem.controller;

import lombok.RequiredArgsConstructor;
import org.example.reactivedem.ds.Response;
import org.example.reactivedem.service.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;

    @GetMapping("/square/{input}")
    public Response square(@PathVariable int input) {
        return mathService.getOutput(input);
    }

    @GetMapping("/table/{input}")
    public List<Response> table(@PathVariable int input) {
        return mathService.multiple(input);
    }
}
