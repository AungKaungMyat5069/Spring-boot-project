package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

public class CustomerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // First Running
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("First Bean BeanFactoryPostProcessor postProcessBeanFactory");
        Arrays.stream(beanFactory.getBeanDefinitionNames()).sorted().forEach(System.out::println);
    }
}
