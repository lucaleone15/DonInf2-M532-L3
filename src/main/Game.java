package main;


import play.CommandRegistery;
import play.Player;

public class Game {
    private Player player;
    private WorldMap worldMap;
    private CommandRegistery commandRegistery;

    public Game(){
        System.out.println("Initializing game...");
    }
    
    public void run() {
        System.out.println("Running game...");
        // your runtime code here...
        // Initialization of the map and of the player
        int row = 20;
        int col = 20;
        WorldMap worldMap = new WorldMap(row, col);
        Player player = new Player();
        worldMap.setPlayerLocation(0,0);
        // end of game
    }

}