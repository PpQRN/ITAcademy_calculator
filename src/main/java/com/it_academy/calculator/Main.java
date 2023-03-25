package com.it_academy.calculator;


public class Main {

    public static void main(String[] args) {
        System.out.println("Введите первое число");
        double number1 = Calculator.userNumberInput();
        System.out.println("Введите второе число");
        double number2 = Calculator.userNumberInput();
        System.out.println("Введите действие, которое хотите совершить (доступные действия +,-,/,*)");
        char sign = Calculator.userSignInput();
        try {
            double result = Calculator.calculate(number1, number2, sign);
            System.out.println(result);
        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
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