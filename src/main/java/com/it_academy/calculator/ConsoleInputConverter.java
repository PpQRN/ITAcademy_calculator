package com.it_academy.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputConverter {

    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static double convertInputToDouble(String input) {
        return Double.parseDouble(input);
    }


    public static char convertInputToChar(String input) {
        if (input.toCharArray().length != 1 || !Arrays.asList('+', '-', '*', '/').contains(input.charAt(0))) {
            throw new IllegalArgumentException("Wrong input, try again");
        }
        return input.charAt(0);
    }
}
