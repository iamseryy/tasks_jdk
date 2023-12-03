package ru.task2.model;

public class Backender extends Developer implements Backend{

    public Backender(String name) {
        super(name);
    }

    @Override
    public void backendDevelop() {
        System.out.println("I am " + super.getName() + "and I am developing a web service");
    }
}
