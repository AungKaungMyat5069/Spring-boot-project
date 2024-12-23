package org.example.counterservice.bean;

import org.example.counterservice.ds.RequestCounter;
import org.springframework.stereotype.Component;

@Component
public class StatelessBean {



    public int addCount(RequestCounter counter) {
        return counter.getCounter() + 1;
    }
}
