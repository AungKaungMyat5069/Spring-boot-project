package org.example.counterservice.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class StatefulBean {

    private int counter;

    public int getCounter() {
        return counter++;
    }
}
