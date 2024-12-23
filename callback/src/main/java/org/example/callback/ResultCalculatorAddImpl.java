package org.example.callback;

public class ResultCalculatorAddImpl implements ResultCalculator {

    @Override
    public double calculate(int num) {
        return GeneratePairNum.generatePairs(num).stream()
                .map(p -> p.getFirst() + p.getSecond()).mapToDouble(d -> d).sum();
    }
}
