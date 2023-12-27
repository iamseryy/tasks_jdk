package ru.task5.model;

import java.util.concurrent.TimeUnit;

public class DinnerTable {
    private final String DINNER_TABLE_RESERVED = "The dinning table is reserved by %s.\n";
    private final String  PHILOSOPHER_IS_EATING = "%s is eating.\n";
    private final String  PHILOSOPHER_HAS_EATEN = "%s has just eaten. The dinning table is free.\n";
    private static final int DURATION_RESERVED_IN_MILLISECONDS = 500;

    private static String pre

    public synchronized void reserved() {
        try {
            System.out.printf(DINNER_TABLE_RESERVED, Thread.currentThread().getName());
            System.out.printf(PHILOSOPHER_IS_EATING, Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(DURATION_RESERVED_IN_MILLISECONDS);
            System.out.printf(PHILOSOPHER_HAS_EATEN, Thread.currentThread().getName());
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
