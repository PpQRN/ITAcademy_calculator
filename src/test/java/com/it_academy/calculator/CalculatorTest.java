package com.it_academy.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"5, 10, 15", "-5, 10, 5", "5, -10, -5", "-5, -10, -15", "0, 0, 0"})
    public void testAddingfunction(int first, int second, int third){
        assertEquals(third, Calculator.calculate(first, second, '+'), "НЕ работает");
    }

    @Test
    public void divideByZero(){
        Exception exception = assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(15, 0, '/'));
        assertEquals("Нельзя делить на ноль :)", exception.getMessage());
    }
}
