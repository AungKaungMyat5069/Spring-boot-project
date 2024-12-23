package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {

    @Pointcut("target(org.example.service.CurrencyServiceImpl)")
    public void pointcut() {}

//    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }
}
