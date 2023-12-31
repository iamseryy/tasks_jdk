package org.example.model;

import java.util.HashMap;

public class Statistics {
    private HashMap<Integer, Strategy> results;
    private Integer gameNumber;

    public Statistics() {
        this.results = new HashMap<>();
        this.gameNumber = 0;
    }

    public void save(Strategy strategy) {
        this.results.put(++this.gameNumber, strategy);
    }

    private long getResult(Strategy strategy) {
        return results.entrySet().stream().filter(it -> it.getValue() == strategy).count();
    }

    @Override
    public String toString() {
        return "\nStatistics:\n" +
                "Strategy - change the door = " + getResult(Strategy.CHANGE_DOOR) + "\n" +
                "Strategy - leave as is = " + getResult(Strategy.LEAVE_AS_IS) + "\n";
    }
}
