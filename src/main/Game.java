package main;


import command.Command;
import command.HelpCommand;
import command.MapCommand;
import command.MoveCommand;
import play.CommandRegistry;
import play.Player;

import java.util.Scanner;

public class Game {
    private Player player;
    private WorldMap worldMap;
    private CommandRegistry commandRegistry;
    private Scanner scanner;

    public Game(){
        System.out.println("Initializing game...");
    }

    public void initialization() {

        // Initialization of the map and of the player
        int row = 10;
        int col = 10;

        this.worldMap = new WorldMap(row, col);
        this.player = new Player();
        this.worldMap.setPlayerLocation(0, 0);

        this.commandRegistry = new CommandRegistry();
        Command mapCommand = new MapCommand("map", "Type 'map' to see the map.", worldMap);
        Command moveCommand = new MoveCommand("move", "Use 'move <north|south|east|west>' to move your player", worldMap);
        Command helpCommand = new HelpCommand("help", "Use 'help' to know which commands are usable", commandRegistry);
        this.commandRegistry.register("move", moveCommand);
        this.commandRegistry.register("help", helpCommand);
        this.commandRegistry.register("map", mapCommand);
        this.scanner = new java.util.Scanner(System.in);
    }


    public void run() {
        System.out.println("Running game...");
        // your runtime code here...
        this.initialization();

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Use 'move <north|south|east|west>'");
        System.out.println("Use 'help' to know which commands are usable");
        System.out.println("Type 'map' to see the map.");
        System.out.println("Type 'quit' to exit.");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) break;

            String result = commandRegistry.execute(input);
            System.out.println(result);
        }

        System.out.println("Thanks for playing!");
        // end of game
    }

}