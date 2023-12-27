package ru.task5.model;

import java.util.stream.IntStream;

public class Philosopher implements Runnable{
    private static final String THINK_ACTIVITY = "%s is thinking now.\n";
    private static final int LIFE_DURATION = 3;
    private String name;
    private DinnerTable dinnerTable;

    public Philosopher(String name, DinnerTable dinnerTable) {
        this.name = name;
        this.dinnerTable = dinnerTable;
    }

    public String getName() {
        return name;
    }

    private void live() {
        System.out.printf(THINK_ACTIVITY, this.name);
        dinnerTable.reserved();
    }

    @Override
    public void run() {
        IntStream.range(0,LIFE_DURATION).forEach(it -> live());
    }
}
