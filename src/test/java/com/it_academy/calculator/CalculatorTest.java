package com.it_academy.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Suite
@SelectClasses(ConsoleInputConverterTest.class)
public class CalculatorTest {

    @ParameterizedTest
    @Tag("Залупа")
    @CsvSource(value = {"5, 10, 15", "-5, 10, 5", "5, -10, -5", "-5, -10, -15", "0, 0, 0"})
    public void testAddingfunction(int first, int second, int result){
        assertEquals(result, Calculator.calculate(first, second, '+'), "Неправильно считает сумму");
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 10, -5", "-5, 10, -15", "5, -10, 15", "-5, -10, 5", "0, 0, 0"})
    public void testMinusfunction(int first, int second, int result){
        assertEquals(result, Calculator.calculate(first, second, '-'), "Неправильно считает разницу");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 2", "-1, 2, -2", "1, -2, -2", "-1, -2, 2", "0, 0, 0"})
    public void testMultiplyfunction(int first, int second, int result){
        assertEquals(result, Calculator.calculate(first, second, '*'), "Неправильно считает произведение");
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 1, 2", "-2, 1, -2", "2, -1, -2", "-2, -1, 2", "0, 2, 0"})
    public void testDividingfunction(int first, int second, int result){
        assertEquals(result, Calculator.calculate(first, second, '/'), "Неправильно считает частное");
    }

    @Test
    public void divideByZero(){
        Exception exception = assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(15, 0, '/'));
        assertEquals("Нельзя делить на ноль :)", exception.getMessage());
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
