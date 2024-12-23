package org.example.securitycontextdemo.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.*;

@RestController
public class HelloController {

    
    @GetMapping("/hello")
    public String hello() {
//        when you have security dep, this method will be through the security dispatcher
        // means that all filter are complete
        // this can be use security context
        //this 3 line is same as the below method
        SecurityContext context = SecurityContextHolder.getContext(); // <-- this code will be not work when it is global variable
        Authentication authentication = context.getAuthentication();
        return "Hello " + authentication.getName();
    }

    @GetMapping("/greet")
    public String greet(Principal principal) {
        return "Hello " + principal.getName();

    }

    @Async
    @GetMapping("/goodbye")
    public CompletableFuture<String> goodbye(Principal principal) {
        return CompletableFuture.completedFuture("Goodbye " + principal.getName());
    }

    @GetMapping("/farewell")
    public String farewell() throws ExecutionException, InterruptedException {
        Callable <String> task = () -> {
            SecurityContext context = SecurityContextHolder.getContext();
                return context.getAuthentication().getName();
        };

            ExecutorService e = Executors.newCachedThreadPool();
        try {
            return e.submit(task).get();
        } finally {
            e.shutdown();
        }
    }
}


