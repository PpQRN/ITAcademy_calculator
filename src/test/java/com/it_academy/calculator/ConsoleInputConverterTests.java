package com.it_academy.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleInputConverterTests {

    @Test
    public void testUserNumberInput() {
        String input = "15";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("15", ConsoleInputConverter.getInput(), "Input is not working");
    }

    @Test
    public void testInputToDoubleConversion() {
        assertEquals(15, ConsoleInputConverter.convertInputToDouble("15"));
    }

    @ParameterizedTest
    @CsvSource(value = {"+, +", "-, -", "/, /", "*, *"})
    public void testInputToCharConversion(char sign1, String sign2) {
        assertEquals(sign1, ConsoleInputConverter.convertInputToChar(sign2));
    }

    @ParameterizedTest
    @EmptySource
    @CsvSource(value = "15")
    public void testInputToCharConversionExceptions(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ConsoleInputConverter.convertInputToChar(input));
        assertEquals("Wrong input, try again", exception.getMessage());
    }

    @Test
    public void testConvertInputToDouble_PositiveNumber() {
        String input = "42";
        double expectedOutput = 42.0;
        double actualOutput = ConsoleInputConverter.convertInputToDouble(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testConvertInputToDouble_NegativeNumber() {
        String input = "-5.5";
        double expectedOutput = -5.5;
        double actualOutput = ConsoleInputConverter.convertInputToDouble(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testConvertInputToDouble_InvalidInput() {
        assertThrows(NumberFormatException.class, () -> ConsoleInputConverter.convertInputToDouble("Text"));
    }
}
