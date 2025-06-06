package command;

import item.Item;
import main.Game;
import main.Location;
import main.WorldMap;
import play.Inventory;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class UseCommand extends Command implements ICommand {
    private WorldMap worldMap;
    private Inventory inventory;
    private Scanner scanner;
    private List<String> commandHistory;
    private Game game;

    public UseCommand(String verb, String description, WorldMap worldMap, Inventory inventory, Scanner scanner, List<String> commandHistory, Game game) {
        super(verb, description);
        this.worldMap = worldMap;
        this.inventory = inventory;
        this.scanner = scanner;
        this.commandHistory = commandHistory;
        this.game = game;
    }

    @Override
    public String execute(String instruction) {
        String keyName = instruction.trim();

        if (keyName.isEmpty()) {
            if (Game.isLoading) return "";

            System.out.println(StringStyling.StyleString("Your keys :", Style.BOLD, Color.WHITE));
            inventory.showKeys();
            System.out.print("Enter the name of the key you want to use : ");
            keyName = scanner.nextLine().trim();
            if (!keyName.isEmpty()) {
                commandHistory.add("use " + keyName);
            }
        }

        Item key = inventory.getItem(keyName);
        if (key == null) {
            if (Game.isLoading) return "";
            return StringStyling.StyleString("You don't have the key '" + keyName + "' in your inventory.", Style.BOLD, Color.RED);
        }

        int playerRow = worldMap.getPlayerRow();
        int playerCol = worldMap.getPlayerCol();

        int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        for (int[] dir : directions) {
            int r = playerRow + dir[0];
            int c = playerCol + dir[1];

            if (worldMap.isValidPosition(r, c)) {
                Location loc = worldMap.getLocationAt(r, c);
                if (loc != null && loc.isLocked() && loc.canBeUnlockedWith(key)) {
                    loc.unlock();
                    inventory.removeItemByName(keyName);
                    if (Game.isLoading) return "";
                    return StringStyling.StyleString("You used the key '" + keyName + "' to unlock the " + loc.getName() + ".", Style.BOLD, Color.GREEN);
                }
            }
        }

        if (Game.isLoading) return "";
        return StringStyling.StyleString("There is no locked location nearby that can be unlocked with the key '" + keyName + "'.", Style.BOLD, Color.RED);
    }

}
