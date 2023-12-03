package ru.task2.model;

public class Fullstack extends Developer implements Backend, Frontend{

    public Fullstack(String name) {
        super(name);
    }

    @Override
    public void backendDevelop() {
        System.out.println("I am " + super.getName() + ". I am fullstack developer and I can develop web service");
    }

    @Override
    public void frontendDevelop() {
        System.out.println("I am " + super.getName() + ". I am fullstack developer and I can develop UI");
    }
}
