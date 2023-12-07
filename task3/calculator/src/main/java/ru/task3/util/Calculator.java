package ru.task3.util;

public class Calculator implements Calculatable {
    @Override
    public Double sum(Number number1, Number number2) {
        return calculate(number1, number2, (it1, it2) -> it1.doubleValue() + it2.doubleValue());
    }

    @Override
    public Double subtract(Number number1, Number number2) {
        return calculate(number1, number2, (it1, it2) -> it1.doubleValue() - it2.doubleValue());
    }

    @Override
    public Double multiply(Number number1, Number number2) {
        return calculate(number1, number2, (it1, it2) -> it1.doubleValue() * it2.doubleValue());
    }

    @Override
    public Double divide(Number number1, Number number2) {
        return calculate(number1, number2, (it1, it2) -> it1.doubleValue() / it2.doubleValue());
    }


    private static <T extends Number, U extends Number> Double calculate(T number1, U number2, Operation operation) {
        return operation.operate(number1, number2);
    }
}
