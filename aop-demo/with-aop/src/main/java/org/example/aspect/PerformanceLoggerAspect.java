package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLoggerAspect {

    @Around("@annotation(org.example.aspect.PerformanceAspectAnnotation)")
    public Object performanceLoggerAspect(ProceedingJoinPoint joinPoint) throws Throwable  {

        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println(joinPoint.getSignature().getName() + " took " + (endTime - startTime) + "ms");
        }
    }
}
