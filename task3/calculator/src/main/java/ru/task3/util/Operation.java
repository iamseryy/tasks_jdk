package ru.task3.util;

@FunctionalInterface
interface Operation <T extends Number, U extends Number> {
    Double operate(T num1, U num2);
}
