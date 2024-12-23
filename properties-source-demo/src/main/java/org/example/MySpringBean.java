package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MySpringBean {
    @Value("${app.name")
    private String appName;

    @Value("${app.course}")
    private String course;

    @Value("${app.fee}")
    private int fee;

    @Value("${app.discount}")
    private double discount;

    @Value("${app.open}")
    private boolean open;

    @Value("#{'${OS}'.toUpperCase()}")
    private String javaHome;

    public void printAll() {
        System.out.println("Name :" + appName);
        System.out.println("Course :"+ course);
        System.out.println("Fee :" + fee);
        System.out.println("Discount :" + discount);
        System.out.println("Available :" + open);
        System.out.println("System Path :" + javaHome);
    }

    //$ -
    //# - SPEL
}
