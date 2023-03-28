package com.it_academy.calculator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter first number");
        double number1 = getUserInput();
        System.out.println("Enter second number");
        double number2 = getUserInput();
        Character sign = null;
        System.out.println("Enter the operation you want to perform (available operation +,-,/,*)");
        while (sign == null) {
            try {
                String input = ConsoleInputConverter.getInput();
                sign = ConsoleInputConverter.convertInputToChar(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        try {
            double result = Calculator.calculate(number1, number2, sign);
            System.out.println(result);
        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static double getUserInput() {
        Double number = null;
        while (number == null) {
            try {
                String input = ConsoleInputConverter.getInput();
                number = ConsoleInputConverter.convertInputToDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println("Incorrect input");
            }
        }
        return number;
    }
}
