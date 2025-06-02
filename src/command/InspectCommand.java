package command;

import item.Item;
import item.Letter;
import play.Inventory;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Scanner;

public class InspectCommand extends Command implements ICommand {
    private Inventory inventory;
    private Scanner scanner;

    public InspectCommand(String verb, String description, Inventory inventory, Scanner scanner) {
        super(verb, description);
        this.inventory = inventory;
        this.scanner = scanner;
    }

    @Override
    public String execute(String instruction) {
        if (inventory.getPlayerInventory().isEmpty()) {
            return StringStyling.StyleString("Your inventory is empty.", Style.BOLD, Color.WHITE);
        }

        inventory.showInventory();

        System.out.print("Enter the name of the item you want to inspect: ");
        String itemName = scanner.nextLine().trim();

        if (itemName.isEmpty()) {
            return StringStyling.StyleStringBright("You did not enter any item name.", Style.BOLD, Color.WHITE, Color.RED);
        }

        Item item = inventory.getItem(itemName);
        if (item == null) {
            return StringStyling.StyleString("You don't have any item named '" + itemName + "' in your inventory.", Style.BOLD, Color.RED);
        }

        String description = item.getDescription();
        return description != null ? description : StringStyling.StyleString("No description available for this item.", Style.BOLD, Color.WHITE);
    }
}

