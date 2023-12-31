package org.example.model;

public class Statistics {
    private int changeSelectionDoorStrategy;
    private int leaveAsIsStrategy;

    public Statistics() {
        this.changeSelectionDoorStrategy = 0;
        this.leaveAsIsStrategy = 0;
    }

    public int incrementChangeSelectionDoorStrategy() {
        return this.changeSelectionDoorStrategy++;
    }

    public int incrementLeaveAsIsStrategy() {
        return this.leaveAsIsStrategy++;
    }

    @Override
    public String toString() {
        return "\nStatistics:\n" +
                "Strategy - change the door = " + changeSelectionDoorStrategy + "\n" +
                "Strategy - leave as is = " + leaveAsIsStrategy + "\n";
    }
}
