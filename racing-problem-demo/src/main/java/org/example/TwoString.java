package org.example;

public class TwoString {



    public static void printTwoString(String a, String b) {
        System.out.print(a);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(b);
    }
}
