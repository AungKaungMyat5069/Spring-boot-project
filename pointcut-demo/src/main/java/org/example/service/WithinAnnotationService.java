package org.example.service;

import org.example.annotation.withinAnnotation;
import org.springframework.stereotype.Component;

@Component @withinAnnotation
public class WithinAnnotationService {

    public int changeCurrency(int number) {
        return number;
    }


    public double changeCurrency(double number) {
        return number;
    }


}
