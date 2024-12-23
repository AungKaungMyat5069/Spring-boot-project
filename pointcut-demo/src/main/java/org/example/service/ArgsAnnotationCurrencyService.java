package org.example.service;

import org.example.enum_package.ArgsEnum;
import org.springframework.stereotype.Component;

@Component
public class ArgsAnnotationCurrencyService {

    public String country(ArgsEnum argsEnum) {
        return argsEnum.name();
    }

    public String currency(ArgsEnum argsEnum) {

        if(argsEnum.name().equals(ArgsEnum.JAPAN.name())) {
            return "Yen";
        } else {
            throw new IllegalArgumentException("Currency should be JAPAN");
        }

    }
}
