package ru.task2.model;

public class Fullstack extends Developer implements Backend, Frontend{
    private String name;

    public Fullstack(String name) {
        this.name = name;
    }

    @Override
    public void backendDevelop() {
        System.out.println("I am " + name + ". I am fullstack developer and I can develop web service");
    }

    @Override
    public void frontendDevelop() {
        System.out.println("I am " + name + ". I am fullstack developer and I can develop UI");
    }
}
