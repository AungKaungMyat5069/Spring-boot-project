package org.example.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean2 {

    public SpringBean2() {
        System.out.println("SpringBean2 constructor");
    }
}
