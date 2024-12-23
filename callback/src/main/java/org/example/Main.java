package org.example;

import org.example.callback.ComplexAction;
import org.example.callback.FormatResultRender;
import org.example.callback.ResultCalculatorAddImpl;
import org.example.callback.ResultCalculatorMultiplyImpl;

public class Main {
    public static void main(String[] args) {

        ComplexAction action = new ComplexAction();
        action.action(new FormatResultRender(), new ResultCalculatorMultiplyImpl(), 4);
    }
}