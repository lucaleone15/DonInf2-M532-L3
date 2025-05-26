package command;

import item.Item;
import item.Letter;
import play.Inventory;

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
            return "Your inventory is empty.";
        }

        inventory.showInventory();

        System.out.print("Enter the name of the item you want to inspect: ");
        String itemName = scanner.nextLine().trim();

        if (itemName.isEmpty()) {
            return "You did not enter any item name.";
        }

        Item item = inventory.getItem(itemName);
        if (item == null) {
            return "You don't have any item named '" + itemName + "' in your inventory.";
        }

        String description = item.getDescription();
        return description != null ? description : "No description available for this item.";
    }
}

