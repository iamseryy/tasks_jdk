package ru.task5.model;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DinnerTable {
    private static final String DINNER_TABLE_RESERVED = "The dinning table is reserved by %s.\n";
    private static final String PHILOSOPHER_IS_EATING = "%s is eating.\n";
    private static final String PHILOSOPHER_HAS_EATEN = "%s has just eaten. The dinning table is free.\n";
    private static final String WAIT_TURN = "Although %s is hungry, he will have to wait.\n";
    private static final int DURATION_RESERVED_IN_MS = 500;
    private static final int TURN_WAITING_TIME_IN_MS = 15000;
    private final Lock lock;
    private final Condition condition;
    private static Philosopher previousPhilosopher;

    public DinnerTable() {
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
    }

    public void reserved(Philosopher philosopher) {
        this.lock.lock();
        try {
            while (previousPhilosopher != null && previousPhilosopher.equals(philosopher)) {
                System.out.printf(WAIT_TURN, philosopher.getName());
                this.condition.await(TURN_WAITING_TIME_IN_MS, TimeUnit.MILLISECONDS);
            }

            System.out.printf(DINNER_TABLE_RESERVED, Thread.currentThread().getName());
            System.out.printf(PHILOSOPHER_IS_EATING, Thread.currentThread().getName());

            TimeUnit.MILLISECONDS.sleep(DURATION_RESERVED_IN_MS);

            System.out.printf(PHILOSOPHER_HAS_EATEN, Thread.currentThread().getName());

            previousPhilosopher = philosopher;

            this.condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            this.lock.unlock();
        }
    }
}
