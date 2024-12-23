package org.example.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MySpringBean1 {

    public MySpringBean1() {
        System.out.println("MySpringBean1 constructor");
    }
}
