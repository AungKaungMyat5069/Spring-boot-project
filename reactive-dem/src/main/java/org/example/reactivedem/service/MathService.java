package org.example.reactivedem.service;

import org.example.reactivedem.ds.Response;
import org.example.reactivedem.util.SleepUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Response getOutput(int input) {
        return new Response(input * input);
    }

    public List<Response> multiple(int input) {
        return IntStream.rangeClosed(0,10)
                .peek(i -> SleepUtil.sleepSeconds(1))
                .peek(i -> System.out.println("Multiple" + i))
                .mapToObj(i -> new Response(i * input))
                .toList();
    }
}
