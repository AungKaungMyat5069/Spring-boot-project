package org.example.designpattern.singleton;

public class MySingleton {
    private static MySingleton instance;

    private MySingleton() {
        System.out.println("Inside MySingleton");
    }
    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}
