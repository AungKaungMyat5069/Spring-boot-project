package org.example.designpattern.prototype;

public class MyPrototype implements IPrototype {

    private String name;

    public MyPrototype(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        try {
          return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "MyPrototype{" +
                "name='" + name + '\'' +
                '}';
    }
}
