package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//within pointcut takes within package of method/ methods

@Aspect
@Component
public class WithinCurrencyAspect {

    @Pointcut("within(org.example.service.*)")
    public void withinPointcut() {}


//    @Before("withinPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }
}
