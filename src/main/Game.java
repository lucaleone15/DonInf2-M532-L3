package main;


import command.*;
import item.Key;
import item.Puzzle;
import play.CommandRegistry;
import play.Inventory;
import play.Player;

import java.util.ArrayList;
import java.util.List;
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
        int row = 3;
        int col = 3;

        this.worldMap = new WorldMap(row, col);
        Inventory inventory = new Inventory();
        this.player = new Player(inventory);
        this.worldMap.setPlayerLocation(0, 0);
        this.scanner = new java.util.Scanner(System.in);
        this.commandRegistry = new CommandRegistry();

        List<Puzzle> puzzles = new ArrayList<>();
        // PuzzleManager.java
        puzzles.add(new Puzzle(
                "Tower Gate",
                "What has keys but can’t open locks, has space but no room, and you can enter but not go outside?",
                "keyboard",
                new Key("tower", "A metallic key with a T engraved.")
        ));

        puzzles.add(new Puzzle(
                "Crypt Entrance",
                "The more you take, the more you leave behind. What am I?",
                "footsteps",
                new Key("crypt", "An old iron key covered in dust.")
        ));



        Command mapCommand = new MapCommand("map", "Type 'map' to see the map.", worldMap);
        Command moveCommand = new MoveCommand("move", "Use 'move <north|south|east|west>' to move your player", worldMap);
        Command helpCommand = new HelpCommand("help", "Use 'help' to know which commands are usable", commandRegistry);
        Command lookCommand = new LookCommand("look", "Type 'look' to see if there is an object in your player location", worldMap);
        Command inspectCommand = new InspectCommand("inspect", "Type 'inspect' to see an item description", inventory, scanner);
        Command takeCommand = new TakeCommand("Take", "Use 'take' to put an item in your inventory", worldMap, inventory);
        Command useCommand = new UseCommand("Use", "Type 'use' to use a key to unlock a location", worldMap, inventory, scanner);
        Command sayCommand = new SayCommand("say", "Use 'say' <your answer> to resolve a puzzle", worldMap, inventory, puzzles);
        this.commandRegistry.register("move", moveCommand);
        this.commandRegistry.register("help", helpCommand);
        this.commandRegistry.register("map", mapCommand);
        this.commandRegistry.register("look", lookCommand);
        this.commandRegistry.register("inspect", inspectCommand);
        this.commandRegistry.register("take", takeCommand);
        this.commandRegistry.register("use", useCommand);
        this.commandRegistry.register("say", sayCommand);
    }


    public void run() {
        System.out.println("Running game...");
        // your runtime code here...
        this.initialization();

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Use 'move <north|south|east|west>'");
        System.out.println("Use 'help' to know which commands are usable");
        System.out.println("Type 'map' to see the map.");
        System.out.println("Type 'look' to see if there is an object in your player location");
        System.out.println("Type 'inspect' to see an item description");
        System.out.println("Use 'take' to put an item in your inventory");
        System.out.println("Type 'use' to use a key to unlock a location");
        System.out.println("Use 'say' <your answer> to resolve a puzzle");
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