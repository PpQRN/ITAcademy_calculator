package com.it_academy.calculator;

public class Main {

    public static void main(String[] args) {
        Double number1 = null;
        Double number2 = null;
        Character sign = null;
        System.out.println("Enter first number");
        while (number1 == null) {
            try {
                String input = ConsoleInputConverter.getInput();
                number1 = ConsoleInputConverter.convertInputToDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println("Enter second number");
        while (number2 == null) {
            try {
                String input = ConsoleInputConverter.getInput();
                number2 = ConsoleInputConverter.convertInputToDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println(exception.getMessage());
            }
        }
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


//        System.out.println("Введите первое число");
//        double number1 = Calculator.userNumberInput();
//        System.out.println("Введите второе число");
//        double number2 = Calculator.userNumberInput();
//        System.out.println("Введите действие, которое хотите совершить (доступные действия +,-,/,*)");
//        char sign = Calculator.userSignInput();
//        try {
//            double result = Calculator.calculate(number1, number2, sign);
//            System.out.println(result);
//        } catch (IllegalArgumentException | ArithmeticException exception) {
//            System.out.println(exception.getMessage());
//        }


            //Scanner sc = new Scanner(System.in);
            //Calculator calculator = new Calculator();
            //calculator.userNumberInput(sc.nextLine());
//        try {
//            System.out.println("Введите первое число");
//            double number1 = Calculator.userNumberInput();
//            System.out.println("Введите второе число");
//            double number2 = Calculator.userNumberInput();
//            System.out.println("Введите действие, которое хотите совершить (доступные действия +,-,/,*)");
//            char sign = Calculator.userSignInput();
//            double result = Calculator.calculate(number1, number2, sign);
//            System.out.println(result);
//        }  catch (IndexOutOfBoundsException exception) {
//            System.out.println("Вы не ввели знак операции, попробуйте ещё раз");
//        } catch (IllegalArgumentException | ArithmeticException exception) {
//            System.out.println(exception.getMessage());
//        }
        }
    }
}