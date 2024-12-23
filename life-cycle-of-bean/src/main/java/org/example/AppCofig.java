package org.example;

import org.example.bean.SpringBean1;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// this is We want to tell which is first and last to work

@Configuration
@ComponentScan
public class AppCofig {

    //In App config
    //First Runner
    @Bean
    public BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomerBeanFactoryPostProcessor();
    }

    // Second Runner(one object one run)
    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new CustomerBeanPostProcessor();
    }

    // Bean Runner(util bean close)
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }
}
