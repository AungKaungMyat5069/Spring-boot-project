package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ArgsAnnotationCurrencyAspect {


    @Pointcut("@args(org.example.annotation.ArgsAnnotation)")
    public void argsAnnotationPointcut() {}

//    @Before("argsAnnotationPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));
    }

    // throwing variable is same as in argument Exception variable
//    @AfterThrowing(value = "argsAnnotationPointcut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println(exception.getMessage() + " in " + joinPoint.getSignature().getName());
    }
    // returning variable is same as in argument  variable
//    @AfterReturning(value = "argsAnnotationPointcut()", returning = "value")
    public void afterReturning(JoinPoint joinPoint, String value) {
        System.out.println(joinPoint.getSignature().getName() + " returns value:  " + value +  ", arguments of " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("argsAnnotationPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        @Before
        System.out.println(joinPoint.getSignature().getName() +
                " method came like " + Arrays.toString(joinPoint.getArgs()));
        try{
        Object args = joinPoint.proceed();
        System.out.println("Value of: " + (String) args);

        } catch (Exception e){
//            @AfterThrowing
            System.err.println("Value of: " + e.getMessage());
        } finally {
            //after Advice
            System.out.println(joinPoint.getSignature().getName() + " method came like " + Arrays.toString(joinPoint.getArgs()));

        }
        //@AfterReturn
        return null;
    }
}
