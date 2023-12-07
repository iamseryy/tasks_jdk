package ru.task3.util;

public interface Calculatable <T extends Number, U extends Number> {
    Double sum(T number1, U number2);
    Double subtract(T number1, U number2);
    Double multiply(T number1, U number2);
    Double divide(T number1, U number2);
}
