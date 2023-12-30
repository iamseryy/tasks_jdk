package org.example;

import java.util.Random;

public class Main {
    private static int changeSelectionDoor = 0;
    private static int leaveAsIs = 0;
    private static final Random random = new Random();
    private final static int TOTAL_GAMES = 10000;

    public static void main(String[] args) {
        play();
        printResult();
    }

    private static void play() {
        for(int i = 0; i < TOTAL_GAMES; i++){
            var doors = initGame();
            int playerChoice = playerMakeMove();
            int hostChoice = hostMakeMove(doors, playerChoice);

            leaveAsIs += doors[playerChoice];
            changeSelectionDoor += doors[3 - playerChoice - hostChoice];
        }
    }

    private static void printResult(){
        System.out.println("Switching wins " + changeSelectionDoor + " times.");
        System.out.println("Staying wins " + leaveAsIs + " times.");
    }

    private static int[] initGame() {
        int[] doors = {0, 0, 0};
        doors[random.nextInt(3)] = 1;
        return doors;
    }

    private static int playerMakeMove(){
        return random.nextInt(3);
    }

    private static int hostMakeMove(int[] doors, int playerChoice){
        int hostChoice;
        do{
            hostChoice = random.nextInt(3);
        } while(hostChoice == playerChoice || doors[hostChoice] == 1);

        return hostChoice;
    }

}