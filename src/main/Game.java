package main;


import command.*;
import item.Key;
import item.Puzzle;
import play.CommandRegistry;
import play.Inventory;
import play.Player;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private WorldMap worldMap;
    private CommandRegistry commandRegistry;
    private Scanner scanner;
    private List<String> commandHistory = new ArrayList<>();
    private static final String SAVE_FILENAME = "savegame.txt";


    public Game(){
        //System.out.println("Initializing game...");
    }

    public void initialization() {

        // Initialization of the map and of the player
        int row = 4;
        int col = 4;

        this.worldMap = new WorldMap(row, col);
        Inventory inventory = new Inventory();
        this.player = new Player(inventory);
        this.worldMap.setPlayerLocation(0, 0);
        this.scanner = new java.util.Scanner(System.in);
        this.commandRegistry = new CommandRegistry();


        List<Puzzle> puzzles = new ArrayList<>();
        puzzles.add(new Puzzle(
                "More you take, more you leave behind.",
                "footsteps",
                new Key("tower", "A heavy iron key to open the ancient Tower.")
        ));

        puzzles.add(new Puzzle(
                "I speak without a mouth and hear without ears...",
                "echo",
                new Key("crypt", "A rusty iron key engraved with the word 'crypt'.")
        ));

        puzzles.add(new Puzzle(
                "What has keys but can't open locks?",
                "piano",
                new Key("sanctuary", "A polished silver key with music symbols.")
        ));

        puzzles.add(new Puzzle(
                "I have cities, but no houses. I have mountains, but no trees...",
                "map",
                new Key("cave", "An ancient key shaped like a compass.")
        ));

        Command mapCommand = new MapCommand("map", "Use 'map' to see the map.", worldMap);
        Command moveCommand = new MoveCommand("move", "Use 'move north/south/east/west' to move.", worldMap);
        Command helpCommand = new HelpCommand("help", "Use 'help' to know which commands are usable.", commandRegistry);
        Command lookCommand = new LookCommand("look", "Use 'look' to see if there is an object in your player location.", worldMap);
        Command inspectCommand = new InspectCommand("inspect", "Use 'inspect' to see an item description.", inventory, scanner);
        Command takeCommand = new TakeCommand("Take", "Use 'take' to put an item in your inventory.", worldMap, inventory);
        Command useCommand = new UseCommand("Use", "Use 'use' to use a key to unlock a location.", worldMap, inventory, scanner);
        Command sayCommand = new SayCommand("say", "Use 'say answer' to resolve a puzzle.", worldMap, inventory, puzzles);
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
        //System.out.println("Running game...");
        // your runtime code here...
        this.initialization();
        System.out.println("Do you want to (1) start a new game or (2) load last save?");
        String choice = scanner.nextLine();
        if(choice.equals("2")) {
            loadSave();
        } else {
            initialization();
        }

        System.out.println(StringStyling.StyleString("Welcome to the Adventure Game !", Style.BOLD, Color.WHITE));
        System.out.println();
        System.out.println("Use 'move north/south/east/west' to move.");
        System.out.println("Use 'help' to know which commands are usable.");
        System.out.println("Use 'map' to see the map.");
        System.out.println("Use 'look' to see if there is an object in your player location.");
        System.out.println("Use 'inspect' to see an item description.");
        System.out.println("Use 'take' to put an item in your inventory.");
        System.out.println("Use 'use' to use a key to unlock a location.");
        System.out.println("Use 'say answer' to resolve a puzzle.");
        System.out.println("Use 'quit' to exit.");
        System.out.println();

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) break;

            String result = commandRegistry.execute(input);
            System.out.println(StringStyling.StyleString(result, Style.BOLD, Color.WHITE));

            if(input.equalsIgnoreCase("save")) {
                saveGame();
                System.out.println("Game saved.");
            }

            // enregistrer la commande dans l'historique sauf "save" et "quit"
            commandHistory.add(input);
        }

        System.out.println(StringStyling.StyleString("Thanks for playing!", Style.BOLD, Color.WHITE));
        // end of game
    }

    private void saveGame() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILENAME))) {
            for(String cmd : commandHistory) {
                writer.write(cmd);
                writer.newLine();
            }
        } catch(IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    private void loadSave() {
        try {
            List<String> savedCommands = Files.readAllLines(Paths.get(SAVE_FILENAME));
            initialization();
            for(String cmd : savedCommands) {
                commandHistory.add(cmd);
                commandRegistry.execute(cmd);
            }
            System.out.println("Save loaded.");
        } catch(IOException e) {
            System.out.println("No save file found, starting new game.");
            initialization();
        }
    }

}