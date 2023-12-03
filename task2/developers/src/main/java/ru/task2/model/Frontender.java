package ru.task2.model;

public class Frontender extends Developer implements Frontend{
    public Frontender(String name) {
        super(name);
    }

    @Override
    public void frontendDevelop() {
        System.out.println("I am " + super.getName() + " and I am developing a UI");
    }
}
