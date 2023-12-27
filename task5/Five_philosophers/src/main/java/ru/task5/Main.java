package ru.task5;

import ru.task5.model.DinnerTable;
import ru.task5.model.Philosopher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int TOTAL_PHILOSOPHER = 5;

    public static void main(String[] args) {
        final var dinnerTable = new DinnerTable();
        final var threads = new Thread[]{new Thread(new Philosopher("Philosopher1", dinnerTable)), new Thread(new Philosopher("Philosopher2", dinnerTable))};
        final var threads1 = IntStream.range(1, TOTAL_PHILOSOPHER)

        startThreads(threads);


//        Table table = new Table();
//        for (int i = 0; i < 5; i++) {
//            Thread philThread = new Thread(new Philosopher(table), "Философ №" + (i + 1));
//            philThread.start();
    }


    private static Thread createThread(Philosopher philosopher){
        return new Thread(philosopher, philosopher.getName());
    }

    private static void startThreads(Thread[] threads) {
        Arrays.stream(threads).forEach(Thread::start);
    }

//    static class Table {
//        synchronized void useTable() {
//            String name = Thread.currentThread().getName();
//            System.out.println(name + ": кушаю");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(name + ": стол свободен!");
//            notifyAll();
//            try {
//                System.out.println(Thread.currentThread().getName() + ": Думаю...");
//                wait(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    static class Philosopher implements Runnable {
//        final Table table;
//
//        Philosopher(Table table) {
//            this.table = table;
//        }
//        @Override
//        public void run() {
//            for (int i = 0; i < 3; i++) {
//                table.useTable();
//            }
//        }
//    }
}
