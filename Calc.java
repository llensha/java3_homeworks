package Lesson_5.Homework_5;

import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор для выполнения четырех арифметических операций c двумя целыми числами");
        System.out.print("Введите первое целое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int number2 = scanner.nextInt();
        System.out.println("Результаты вычислений:");

        Operationable operationAddition;
        operationAddition = (x, y) -> x + y;
        int resultAddition = operationAddition.calculate(number1, number2);
        System.out.println(String.format("Сложение: %d + %d = %d", number1, number2, resultAddition));

        Operationable operationSubtraction;
        operationSubtraction = (x, y) -> x - y;
        int resultSubtraction = operationSubtraction.calculate(number1, number2);
        System.out.println(String.format("Вычитание: %d - %d = %d", number1, number2, resultSubtraction));

        Operationable operationMultiplication;
        operationMultiplication = (x, y) -> x * y;
        int resultMultiplication = operationMultiplication.calculate(number1, number2);
        System.out.println(String.format("Умножение: %d * %d = %d", number1, number2, resultMultiplication));

        Operationable operationDivision = (int x, int y) -> {
            if (y == 0)
                return 0;
            else
                return x / y;
        };
        int resultDivision = operationDivision.calculate(number1, number2);
        System.out.println(String.format("Целочисленное деление: %d / %d = %d", number1, number2, resultDivision));
    }
}

interface Operationable {
    int calculate(int x, int y);
}
