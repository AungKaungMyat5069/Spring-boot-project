package com.jdc;

import org.example.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void return_zero_when_input_is_empty() {
        assertThat(stringCalculator.add(" "), equalTo(0));
    }

    @Test
    public void return_integer_when_input_is_string() {
        assertThat(stringCalculator.add("7"), equalTo(7));
    }

    @Test
    public void return_addition_when_input_is_two_number_string() {
        assertThat(stringCalculator.add("7 , 5"), equalTo(12));
    }

    @Test
    public void return_sum_num_when_input_is_multiple_number_string() {
        assertThat(stringCalculator.add("5,5 , , 5 , 5, 5"), equalTo(25));
    }

    @Test
    public void return_sum_ignore_when_input_is_less_1000_number_string() {
        assertThat(stringCalculator.add("1, 1100,1"), equalTo(2));
    }
}
