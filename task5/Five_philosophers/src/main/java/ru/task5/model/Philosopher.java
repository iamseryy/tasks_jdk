package ru.task5.model;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Philosopher implements Runnable{
    private static final String THINK_ACTIVITY = "%s is thinking now.\n";
    private static final String PHILOSOPHER_WANT_EAT = "%s want to eat.\n";
    private static final int LIFE_DURATION = 3;
    private static final int MAX_DURATION_THOUGHT_MS = 10000;
    private static final int MIN_DURATION_THOUGHT_MS = 1;
    private final Random randThoughtProcess;

    private String name;
    private DinnerTable dinnerTable;

    public Philosopher(String name, DinnerTable dinnerTable) {
        this.name = name;
        this.dinnerTable = dinnerTable;
        this.randThoughtProcess = new Random();
    }

    public String getName() {
        return name;
    }

    private void live() {
        think();
        eat();
    }

    private void think() {
        try {
            System.out.printf(THINK_ACTIVITY, this.name);
            TimeUnit.MILLISECONDS.sleep(randThoughtProcess.nextInt((MAX_DURATION_THOUGHT_MS - MIN_DURATION_THOUGHT_MS) + 1) +
                    MIN_DURATION_THOUGHT_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void eat() {
        System.out.printf(PHILOSOPHER_WANT_EAT, this.name);
        dinnerTable.reserved(this);
    }

    @Override
    public void run() {
        IntStream.range(0,LIFE_DURATION).forEach(it -> live());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Philosopher philosopher = (Philosopher) o;
        return Objects.equals(this.name, philosopher.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
