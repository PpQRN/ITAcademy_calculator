package com.it_academy.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleInputConverterTest {

    @Test
    public void checkUserNumberInput() {
        String input = "15";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("15", ConsoleInputConverter.getInput(), "Не работает input");
    }

    @Test
    public void checkInputToDoubleConvertion(){
        assertEquals(15, ConsoleInputConverter.convertInputToDouble("15"));
    }

    @ParameterizedTest
    @CsvSource(value = {"+, +", "-, -", "/, /", "*, *"})
    public void checkInputToCharConversion(char sign1, String sign2){
        assertEquals(sign1, ConsoleInputConverter.convertInputToChar(sign2));
    }

    @ParameterizedTest
    //@NullAndEmptySource
    @CsvSource (value = "This is text")
    public void checkInputToDoubleConversionExeptions(String input){
        Exception exception = assertThrows(NumberFormatException.class,
                () -> ConsoleInputConverter.convertInputToDouble(input));
        assertEquals("Не было введено число, попробуйте ещё раз", exception.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    @CsvSource (value = "15")
    public void checkInputToCharConversionExeptions(String input){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> ConsoleInputConverter.convertInputToChar(input));
        assertEquals("Wrong input, try again", exception.getMessage());
    }

}
