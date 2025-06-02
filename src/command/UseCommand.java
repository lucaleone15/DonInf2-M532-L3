package command;

import item.Item;
import main.Location;
import main.WorldMap;
import play.Inventory;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Scanner;

public class UseCommand extends Command implements ICommand {
    private WorldMap worldMap;
    private Inventory inventory;
    private Scanner scanner;

    public UseCommand(String verb, String description, WorldMap worldMap, Inventory inventory, Scanner scanner) {
        super(verb, description);
        this.worldMap = worldMap;
        this.inventory = inventory;
        this.scanner = scanner;
    }

    @Override
    public String execute(String instruction) {
        String keyName = instruction.trim();

        // Si pas de clé spécifiée, afficher les clés et demander la saisie
        if (keyName.isEmpty()) {
            System.out.println("Your keys:");
            inventory.showKeys(); // Méthode à créer pour n’afficher QUE les clés, pas les autres items
            System.out.print("Enter the name of the key you want to use : ");
            keyName = scanner.nextLine().trim();
        }

        Item key = inventory.getItem(keyName);
        if (key == null) {
            return StringStyling.StyleStringBright("You don't have the key '" + keyName + "' in your inventory.", Style.BOLD, Color.WHITE, Color.RED);
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
                    return StringStyling.StyleString("You used the key '" + keyName + "' to unlock the " + loc.getName() + ".", Style.BOLD, Color.GREEN);
                }
            }
        }

        return StringStyling.StyleStringBright("There is no locked location nearby that can be unlocked with the key '" + keyName + "'.", Style.BOLD, Color.WHITE, Color.RED);
    }
}
