package org.example;


// thread can be extended Thread or implements the Runnable
public class MyThreadClass implements Runnable{

    private String s1;
    private String s2;

    public MyThreadClass(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        TwoString.printTwoString(s1, s2);
    }
}
