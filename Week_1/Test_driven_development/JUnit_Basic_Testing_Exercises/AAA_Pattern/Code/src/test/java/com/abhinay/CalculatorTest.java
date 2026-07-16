package com.abhinay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Creating Calculator instance...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up Calculator instance...");
        calculator = null;
    }

    @Test
    public void testAdd() {
        int num1 = 6;
        int num2 = 4;

        int result = calculator.add(num1, num2);

        assertEquals(10, result);
    }

    @Test
    public void testSubtract() {
        int num1 = 6;
        int num2 = 4;

        int result = calculator.subtract(num1, num2);

        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        int num1 = 6;
        int num2 = 4;

        int result = calculator.multiply(num1, num2);

        assertEquals(24, result);
    }

    @Test
    public void testDivide() {
        int num1 = 20;
        int num2 = 4;

        int result = calculator.divide(num1, num2);

        assertEquals(5, result);
    }
}