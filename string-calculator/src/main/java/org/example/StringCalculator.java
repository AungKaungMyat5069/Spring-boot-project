package org.example;

import java.util.Arrays;

public class StringCalculator {

    public int add(String input) {

        return getArrayStringSum(commaSplitString(input));
    }

    private String[] commaSplitString(String input) {
        if (input.contains(",")) {
            return input.split(",");
        }
        return new String[]{input};
    }


    private int getArrayStringSum(String[] parts) {
        return Arrays.stream(parts).mapToInt(StringCalculator::stringToInt).filter(num -> num < 1000).sum();
    }

    private static int stringToInt(String input) {
        if (input.isBlank()) {
            return 0;
        }
        return Integer.parseInt(input.trim());
    }

}
