package com.IT_academy.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите первое число");
            double number1 = Double.parseDouble(sc.nextLine());
            System.out.println("Введите второе число");
            double number2 = Double.parseDouble(sc.nextLine());
            System.out.println("Введите действие, которое хотите совершить (доступные действия +,-,/,*)");
            char sign = sc.nextLine().charAt(0);
            double result = Calculator.calculate(number1, number2, sign);
            System.out.println(result);
        } catch (NumberFormatException exception) {
            System.out.println("Не было введено число, попробуйте ещё раз");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Вы не ввели знак операции, попробуйте ещё раз");
        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
