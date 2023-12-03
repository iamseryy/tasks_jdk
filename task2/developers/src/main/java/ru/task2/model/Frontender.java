package ru.task2.model;

public class Frontender extends Developer implements Frontend{
    private String name;

    public Frontender(String name) {
        this.name = name;
    }

    @Override
    public void frontendDevelop() {
        System.out.println("I am " + name + " and I am developing a UI");
    }
}
