package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AmaingSomethingAspect {

    @Pointcut("this(org.example.service.AmazingSomething)")
    public void CibPointcut() {}

//    @Before("CibPointcut()")
    public void beforeCibPointcut(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "method like that" + Arrays.toString(joinPoint.getArgs()));
    }
}
