package org.example;

import org.example.quest.Dragon;
import org.example.warrior.Knight;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Knight knight = new Knight();
//        knight.setQuest(new Dragon());
//        System.out.println(knight.doQuest());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Knight knight = context.getBean(Knight.class);
        System.out.println(knight.doQuest());

    }
}