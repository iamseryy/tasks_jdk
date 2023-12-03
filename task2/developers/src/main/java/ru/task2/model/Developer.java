package ru.task2.model;

public abstract class Developer {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
