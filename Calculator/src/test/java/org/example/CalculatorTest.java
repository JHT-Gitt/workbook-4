package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add_shouldReturnSumOfTwoNumbers() {
        int firstNumber = 2;
        int secondNUmber =4;
        int expectedResult = 6;
        Calculator c = new Calculator();

        int actual = c.add(firstNumber,secondNUmber);
        assertEquals(expectedResult,actual);
    }

    @Test
    void subtract() {

            int firstNum = 10;
            int secondNum = 9;
            int e = 1;
            Calculator c = new Calculator();
            int a = c.subtract(firstNum,secondNum);
            assertEquals(e,a);

    }
}