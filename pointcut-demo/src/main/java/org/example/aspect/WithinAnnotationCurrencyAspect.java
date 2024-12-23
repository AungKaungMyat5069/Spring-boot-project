package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@within - is used for class type all method and can only the class work

@Aspect
@Component
public class WithinAnnotationCurrencyAspect {


    @Pointcut("@within(org.example.annotation.withinAnnotation))")
    public void withinAnnotationPointcut() {}

//    @Before("withinAnnotationPointcut()")
    public void beforeWithinAnnotation(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }
}
