package org.example;


import org.example.enum_package.ArgsEnum;
import org.example.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        CurrencyService currencyService = context.getBean(CurrencyService.class);
//        currencyService.calculate(1000);
//        AmazingSomething something = context.getBean(AmazingSomething.class);
//        something.service(100);
//
//        // with '@within'  pointcut
//        WithinAnnotationService withinAnnotationService = context.getBean(WithinAnnotationService.class);
//        withinAnnotationService.changeCurrency(12);
//        withinAnnotationService.changeCurrency(1.4);
//
//        // with 'bean' pointcut
//        System.out.println("Bean pointcut");
//        BeanCurrencyService beanCurrencyService = context.getBean(BeanCurrencyService.class);
//        beanCurrencyService.calculate(1); // it will work before and after
//        System.out.println();
//
//        //with 'args' pointcut
//        System.out.println("Args pointcut");
//        ArgsCurrencyService argsCurrencyService = context.getBean(ArgsCurrencyService.class);
//        argsCurrencyService.calculateArgs(12,23,34, 43);// this will work
//        argsCurrencyService.calculateArgs(1.4,23,43); // this will not work
//        System.out.println();

        //with '@args' pointcut
        System.out.println("Args Annotation pointcut");
        ArgsAnnotationCurrencyService argsAnnotationCurrencyService = context.getBean(ArgsAnnotationCurrencyService.class);
        argsAnnotationCurrencyService.country(ArgsEnum.JAPAN);
        System.out.println();

        //with '@target' pointcut
//        System.out.println("target Annotation pointcut");
//        TargetAnnotationCurrencyService targetAnnotationCurrencyService = context.getBean(TargetAnnotationCurrencyService.class);
//        targetAnnotationCurrencyService.changeCurrency(3);
//        targetAnnotationCurrencyService.changeCurrency(1.4);
//        System.out.println();

        //afterThrowing advice
        System.out.println("After Throwing Advice");
        try {
            System.out.println();
            argsAnnotationCurrencyService.currency(ArgsEnum.UK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();


        //@afterReturn advice
        System.out.println("After Return Advice");
        argsAnnotationCurrencyService.currency(ArgsEnum.JAPAN);
        System.out.println();
    }
}