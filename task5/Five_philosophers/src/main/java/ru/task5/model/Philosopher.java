package ru.task5.model;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Philosopher implements Runnable{
    private static final String THINK_ACTIVITY = "%s is thinking now.\n";
    private static final String PHILOSOPHER_WANT_EAT = "%s want to eat.\n";
    private static final int LIFE_DURATION = 3;
    private static final int MAX_DURATION_THOUGHT = 1000;
    private static final int MIN_DURATION_THOUGHT = 1000;
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
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    private void think() {
        try {
            System.out.printf(THINK_ACTIVITY, this.name);

            if(!name.equals("Philosopher3")) {
            TimeUnit.MILLISECONDS.sleep(randThoughtProcess.nextInt((MAX_DURATION_THOUGHT - MIN_DURATION_THOUGHT) + 1) +
                    MIN_DURATION_THOUGHT);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void eat() {
        System.out.printf(PHILOSOPHER_WANT_EAT, this.name);
        dinnerTable.reserved();
    }

    @Override
    public void run() {
        IntStream.range(0,LIFE_DURATION).forEach(it -> live());
    }
}
