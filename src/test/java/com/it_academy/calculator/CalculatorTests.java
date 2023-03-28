package com.it_academy.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    @ParameterizedTest
    @CsvSource(value = {"5, 10, 15", "-5, 10, 5", "5, -10, -5", "-5, -10, -15", "0, 0, 0"})
    public void testAddingFunction(int first, int second, int result){
        assertEquals(result, Calculator.plus(first, second), "Wrong plus operation result");
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 10, -5", "-5, 10, -15", "5, -10, 15", "-5, -10, 5", "0, 0, 0"})
    public void testMinusFunction(int first, int second, int result){
        assertEquals(result, Calculator.minus(first, second), "Wrong minus operation result");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 2", "-1, 2, -2", "1, -2, -2", "-1, -2, 2", "0, 0, 0"})
    public void testMultiplyFunction(int first, int second, int result){
        assertEquals(result, Calculator.multiply(first, second), "Wrong multiply result");
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 1, 2", "-2, 1, -2", "2, -1, -2", "-2, -1, 2", "0, 2, 0"})
    public void testDividingFunction(int first, int second, int result){
        assertEquals(result, Calculator.divide(first, second), "Wrong division result");
    }

    @Test
    public void testDivideByZero(){
        Exception exception = assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(15, 0, '/'));
        assertEquals("You can't divide by zero", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 2, +, 7", "5, 2, -, 3", "5, 2, *, 10", "6, 3, /, 2"})
    public void testSignSelection(int first, int second, char sign, int result){
        assertEquals(result, Calculator.calculate(first, second, sign), "Incorrect sign selection");
    }

    @Test
    public void testWrongSign(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate(15, 15,'o'));
        assertEquals("Wrong sign", exception.getMessage());
    }

//    @ParameterizedTest
//    @CsvSource(value =  {"1", "-5"})
//    public void checkUserNumberInput(double number){
//        String input = Double.toString(number);
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertEquals(number, Calculator.userNumberInput());
//    }

}
