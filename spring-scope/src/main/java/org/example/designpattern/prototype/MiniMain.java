package org.example.designpattern.prototype;

public class MiniMain {
    public static void main(String[] args) {
        MyPrototype myPrototype = new MyPrototype("MI MI");
        System.out.println(myPrototype);
        MyPrototype myPrototype2 = (MyPrototype) myPrototype.clone();
        System.out.println(myPrototype2);

        boolean test = myPrototype2.equals(myPrototype);
        System.out.println(test);
    }
}
