package org.example;

import org.example.model.Game;
import org.example.model.Statistics;
import java.util.stream.IntStream;

public class Main {
    private final static int TOTAL_GAMES = 1000;

    public static void main(String[] args) {
        var statistics = new Statistics();
        playGames(new Game(statistics));
        printResult(statistics);
    }

    private static void playGames(Game game) {
        IntStream.range(0, TOTAL_GAMES).forEach(it -> game.play());
    }

    private static void printResult(Statistics statistics){
        System.out.printf(statistics.toString());
    }
}