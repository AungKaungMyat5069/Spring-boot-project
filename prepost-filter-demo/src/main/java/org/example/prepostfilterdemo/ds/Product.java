package org.example.prepostfilterdemo.ds;


public class Product {

    private String name;
    private String owner;

    public Product(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }
}
