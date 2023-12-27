package ru.task5.model;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Philosopher implements Runnable{
    private static final String EATING_NOW = "I am %s. I am eating now.\n";
    private static final String HAVE_EATEN = "I am %s. I have eaten.\n";
    private static final int DURATION_LUNCH_ACTIVITY_IN_MILLISECONDS = 500;
    private static final String THINK_ACTIVITY = "I am %s. I'm thinking now..\n";
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

    public void eat() {
        if(!dinnerTable.isDinnerTableReserved()) {
            takeDiningTable();
            System.out.printf(EATING_NOW, this.name);
            try {
                TimeUnit.MILLISECONDS.sleep(DURATION_LUNCH_ACTIVITY_IN_MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf(HAVE_EATEN, this.name);
            leaveDiningTable();
        }
    }

    public void think() {
        System.out.printf(THINK_ACTIVITY, this.name);
    }

    private void takeDiningTable() {
        this.dinnerTable.setDinnerTableReserved(true);
    }

    private void leaveDiningTable() {
        this.dinnerTable.setDinnerTableReserved(false);
    }

    private void live() {
        eat();
        think();
    }

    @Override
    public void run() {
        IntStream.range(0,LIFE_DURATION).forEach(it -> live());
    }
}
