package org.example.callback;

import java.util.List;
import java.util.stream.Stream;

public class GeneratePairNum {

    public static List<Pair> generatePairs(int num) {
        return Stream.generate(() -> new Pair(num, num + 1))
                .peek(System.out::println).limit(3).toList();

    }
}
