package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    @DisplayName("Вычисление факториала")
    void testFactorial() {
        assertEquals(1, Factorial.getFactorial(0));
        assertEquals(1, Factorial.getFactorial(1));
        assertEquals(2, Factorial.getFactorial(2));
        assertEquals(6, Factorial.getFactorial(3));
        assertEquals(24, Factorial.getFactorial(4));
        assertEquals(120, Factorial.getFactorial(5));
    }
}