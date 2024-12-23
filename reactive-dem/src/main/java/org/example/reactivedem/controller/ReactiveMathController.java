package org.example.reactivedem.controller;

import lombok.RequiredArgsConstructor;
import org.example.reactivedem.ds.Response;
import org.example.reactivedem.service.ReactiveMathService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("react")
@RequiredArgsConstructor
public class ReactiveMathController {

    private final ReactiveMathService mathService;

    @GetMapping(value = "/square/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Response> getSquare(@PathVariable Integer id) {
        return mathService.square(id);
    }

    @GetMapping(value = "/table/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> getTable(@PathVariable Integer id) {
        return mathService.squareTable(id);
    }
}
