package org.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BeanCurrencyAspect {

    @Pointcut("bean(beanCurrencyService)")
    public void beanPointcut() {}

    @Before("beanPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("beanPointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }



}
