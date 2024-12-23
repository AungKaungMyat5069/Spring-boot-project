package org.example.service;

import org.example.annotation.TargetAnnotation;
import org.springframework.stereotype.Component;

@Component
@TargetAnnotation
public class TargetAnnotationCurrencyService {

    public int changeCurrency(int number) {
        return number;
    }


    public double changeCurrency(double number) {
        return number;
    }

}
