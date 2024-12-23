package org.example;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private final String name;
    private final int age;
    public Customer(String name, int age) {

        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
