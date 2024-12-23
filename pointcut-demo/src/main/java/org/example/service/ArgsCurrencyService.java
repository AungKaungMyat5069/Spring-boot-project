package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ArgsCurrencyService {

    // this will be work
    public double calculateArgs(double arg1, double arg2, double arg3, double arg4) {
        return arg1 + arg2 + arg3 + arg4;
    }

    // this will not be work
    public double calculateArgs(double arg1, double arg2, double arg3) {
        return arg1 + arg2 + arg3;
    }
}
