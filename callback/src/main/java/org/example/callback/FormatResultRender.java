package org.example.callback;

public class FormatResultRender implements ResultRender {

    @Override
    public void render(ResultCalculator result, int num) {
        System.out.println(result.calculate(num));
    }
}
