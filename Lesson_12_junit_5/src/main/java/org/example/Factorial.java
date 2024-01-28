package org.example;

import java.util.stream.*;

public class Factorial {
    public static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return IntStream.rangeClosed(2, f).reduce((x, y) -> x * y).getAsInt();
        }
    }
}