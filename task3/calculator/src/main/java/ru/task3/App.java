package ru.task3;

import ru.task3.util.Calculator;

public class App 
{
    public static void main( String[] args ){
        var calculator = new Calculator();

        System.out.println(calculator.sum(5, 6));
        System.out.println(calculator.subtract(5.1, 6));
        System.out.println(calculator.multiply(5f, 6.03));
        System.out.println(calculator.divide(5.33, 0));
    }
}
