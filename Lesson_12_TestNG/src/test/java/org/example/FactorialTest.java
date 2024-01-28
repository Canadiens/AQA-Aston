package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class FactorialTest {
    @Test
    void testFactorial() {
        assertEquals(1, Factorial.getFactorial(0));
        assertEquals(1, Factorial.getFactorial(1));
        assertEquals(2, Factorial.getFactorial(2));
        assertEquals(6, Factorial.getFactorial(3));
        assertEquals(24, Factorial.getFactorial(4));
        assertEquals(120, Factorial.getFactorial(5));
    }
}