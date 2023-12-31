package org.example.model;

import java.util.Random;

public class Game {
    private final Random random;
    private Statistics statistics;


    public Game(Statistics statistics) {
        this.random = new Random();
        this.statistics = statistics;
    }

    public void play() {
        var doors = initGame();
        int playerChoice = playerMakeMove();
        int hostChoice = hostMakeMove(doors, playerChoice);

        if(doors[playerChoice] == 1) this.statistics.save(Strategy.LEAVE_AS_IS);
        if(doors[3 - playerChoice - hostChoice] == 1) this.statistics.save(Strategy.CHANGE_DOOR);
    }

    private int[] initGame() {
        int[] doors = {0, 0, 0};
        doors[random.nextInt(3)] = 1;
        return doors;
    }

    private int playerMakeMove(){
        return random.nextInt(3);
    }

    private int hostMakeMove(int[] doors, int playerChoice){
        int hostChoice;
        do{
            hostChoice = random.nextInt(3);
        } while(hostChoice == playerChoice || doors[hostChoice] == 1);

        return hostChoice;
    }
}
