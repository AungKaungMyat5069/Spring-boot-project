package org.example.counterservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.counterservice.bean.StatefulBean;
import org.example.counterservice.ds.ResponseCounter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateful")
@RequiredArgsConstructor
public class StatefulController {

    private final StatefulBean statefulBean;

    @PostMapping("/countUp")
    public ResponseCounter countUp() {
        return new ResponseCounter(statefulBean.getCounter());
    }
}
