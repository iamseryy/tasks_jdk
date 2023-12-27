package ru.task5.model;

public class DinnerTable {
    private final String DINNER_TABLE_FREE = "The dinning table is free";
    private final String DINNER_TABLE_RESERVED = "The dinning table is reserved";
    private boolean isDinnerTableReserved;

    public DinnerTable() {
        this.isDinnerTableReserved = false;
    }

    public boolean isDinnerTableReserved() {
        return this.isDinnerTableReserved;
    }

    public synchronized void setDinnerTableReserved(boolean dinnerTableReserved) {
        this.isDinnerTableReserved = dinnerTableReserved;
        System.out.println(this.isDinnerTableReserved ? DINNER_TABLE_RESERVED: DINNER_TABLE_FREE);
    }
}
