package org.example.reactivedem.service;

import org.example.reactivedem.ds.Response;
import org.example.reactivedem.util.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {

    public Mono<Response> square(int number) {
        return Mono.fromSupplier(() -> number * number)
                .map(Response::new);
    }

    public Flux<Response> squareTable(int number) {
// this sleep Util is side effect cuz

        return Flux.range(0, 10)
//                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Multiple " + i))
                .map(Response::new);
    }
}
