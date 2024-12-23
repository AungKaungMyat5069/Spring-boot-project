package org.example.service;

import org.springframework.stereotype.Component;

import java.util.Currency;

@Component
public class WithinCurrencyService {

    public double changeCurrency(double amount) {
        return amount;
    }
}
