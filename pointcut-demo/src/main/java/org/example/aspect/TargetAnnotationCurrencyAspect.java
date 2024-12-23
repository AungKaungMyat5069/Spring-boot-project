package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TargetAnnotationCurrencyAspect {

    @Pointcut("@target(org.example.annotation.TargetAnnotation)")
    public void targetAnnotationPointcut() {}

    @Before("targetAnnotationPointcut()")
    public void targetAnnotationBeforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }
}
