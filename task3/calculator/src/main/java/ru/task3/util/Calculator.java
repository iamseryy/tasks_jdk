package ru.task3.util;

public class Calculator {
    public static <T extends Number, U extends Number> Double sum(T num1, U num2) {
        return oper(num1, num2, (num1, num2) -> num1 + num2);
    }

    private static <T extends Number, U extends Number> Double oper(T num1, U num2, Operation operation) {
        return operation.operate(num1, num2);
    }
}
