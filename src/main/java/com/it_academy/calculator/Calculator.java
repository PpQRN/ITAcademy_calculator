package com.it_academy.calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    private static double number;

    public Calculator() {
    }

    public static double userNumberInput() {
        Scanner sc = new Scanner(System.in);
        try {
            number = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Не было введено число, попробуйте ещё раз");
            userNumberInput();
        }
        return number;
    }

    public static char userSignInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            try {
                if (userInput.toCharArray().length == 1 && Arrays.asList('+', '-', '*', '/').contains(userInput.charAt(0))) {
                    return userInput.charAt(0);
                }
                System.out.println("Неправильный ввод, попробуйте ещё раз");
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Вы не ввели знак операции, попробуйте ещё раз");
            }
        }
    }

    public static double plus(double number1, double number2) {
        return number1 + number2;
    }

    public static double minus(double number1, double number2) {
        return number1 - number2;
    }

    public static double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Нельзя делить на ноль :)");
        }
        return number1 / number2;
    }

    public static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public static double calculate(double number1, double number2, char sign) {
        double result;
        switch (sign) {
            case '+' -> result = plus(number1, number2);
            case '-' -> result = minus(number1, number2);
            case '/' -> result = divide(number1, number2);
            case '*' -> result = multiply(number1, number2);
            default -> throw new IllegalArgumentException("Вы ввели неверный знак");
        }
        return result;
    }
}