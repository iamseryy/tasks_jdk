package ru.task3;

public class Main {
    public static void main(String[] args) {
        var pair1 = new Pair<>("test1", 100);
        var pair2 = new Pair<>(100.99, "test2");

        System.out.println(pair1.first());
        System.out.println(pair1.second());
        System.out.println(pair1);

        System.out.println(pair2.first());
        System.out.println(pair2.second());
        System.out.println(pair2);
    }
}