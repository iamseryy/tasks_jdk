package ru.task3;

public record Pair<T, U>(T first, U second) {
    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
}
