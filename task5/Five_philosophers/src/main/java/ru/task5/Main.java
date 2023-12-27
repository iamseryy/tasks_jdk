package ru.task5;

import ru.task5.model.DinnerTable;
import ru.task5.model.Philosopher;
import java.util.stream.IntStream;

public class Main {
    private static final int TOTAL_PHILOSOPHER = 5;

    public static void main(String[] args) {
        final var dinnerTable = new DinnerTable();
        IntStream.range(1, TOTAL_PHILOSOPHER + 1)
                .forEach(it -> new Thread(new Philosopher("Philosopher" + it, dinnerTable), "Philosopher" + it).start());
    }
}
