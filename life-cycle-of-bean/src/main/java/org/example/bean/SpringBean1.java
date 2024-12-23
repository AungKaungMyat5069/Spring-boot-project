package org.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringBean1 implements InitializingBean, DisposableBean {


    private SpringBean2 springBean2;

    //Second Runner
    public SpringBean1() {
        System.out.println(" Second Runner SpringBean1 constructor");
    }

    // Dependencies injection
    @Autowired// Third Runner
    public void setSpringBean2(SpringBean2 springBean2) {
        System.out.println(" Third Runner SpringBean2 Autowired");
        this.springBean2 = springBean2;
    }

    //Fifth Runner
    @PostConstruct
    public void postConstructor() {
        System.out.println(" Fifth Runner PostConstruct Runner SpringBean1 constructor");
    }

    //Sixth Runner
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" Sixth Runner afterPropertiesSet Runner SpringBean1 constructor");
    }

    //Seventh Runner
    //Note : you have to declare in the bean annotation like init=...
    public void customInit() {
        System.out.println(" Seventh Runner customer init Runner SpringBean1 constructor");
    }

    //just test
    public void greet(String name) {
        System.out.println("My name is " + name);
    }

    //Tenth Runner
    @PreDestroy
    public void preDestroy() {
        System.out.println(" Tenth Runner preDestroy Runner SpringBean1 constructor");
    }

    //Eleventh Runner
    @Override
    public void destroy() throws Exception {
        System.out.println(" Eleventh Runner destroying Runner SpringBean1 constructor");
    }

    //Twelve Runner
    public void customDestroy() {
        System.out.println("Twelve Runner destroying Runner SpringBean1 constructor");
    }

}
