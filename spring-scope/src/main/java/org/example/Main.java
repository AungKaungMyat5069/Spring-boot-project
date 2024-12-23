package org.example;

import org.example.bean.MySpringBean1;
import org.example.bean.SpringBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        //Singleton Scope
        MySpringBean1 bean1 = context.getBean(MySpringBean1.class);
        MySpringBean1 bean2 = context.getBean(MySpringBean1.class);
        MySpringBean1 bean3 = context.getBean(MySpringBean1.class);
        MySpringBean1 bean4 = context.getBean(MySpringBean1.class);
        MySpringBean1 bean5 = context.getBean(MySpringBean1.class);

        boolean test = bean1.equals(bean2);
        System.out.println(bean3);
        System.out.println(bean4);
        System.out.println(bean5);
        System.out.println(test);
        System.out.println();


        //Prototype Scope
        SpringBean2 sb1 = context.getBean(SpringBean2.class);
        SpringBean2 sb2 = context.getBean(SpringBean2.class);
        SpringBean2 sb3 = context.getBean(SpringBean2.class);
        SpringBean2 sb4 = context.getBean(SpringBean2.class);

        System.out.println(sb1);
        System.out.println(sb2);
        boolean test2 = sb3.equals(sb4);
        System.out.println(test2);

    }
}