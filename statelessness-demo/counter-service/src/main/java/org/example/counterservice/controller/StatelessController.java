package org.example.counterservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.counterservice.bean.StatelessBean;
import org.example.counterservice.ds.RequestCounter;
import org.example.counterservice.ds.ResponseCounter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateless")
@RequiredArgsConstructor
public class StatelessController {

    private final StatelessBean statelessBean;

    @PostMapping("/countUp")
    public ResponseCounter countUp(@RequestBody RequestCounter requestCounter) {
        return new ResponseCounter(statelessBean.addCount(requestCounter));
    }
}
