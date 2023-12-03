package ru.task2.model;

public class Backender extends Developer implements Backend{
    private String name;

    public Backender(String name) {
        this.name = name;
    }

    @Override
    public void backendDevelop() {
        System.out.println("I am " + name + "and I am developing a web service");
    }
}
