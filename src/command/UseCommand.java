package command;

import main.WorldMap;
import play.Inventory;

public class UseCommand extends Command implements ICommand{
    private WorldMap worldMap;
    private Inventory inventory;

    public UseCommand(String verb, String description, WorldMap worldMap, Inventory inventory) {
        super(verb, description);
        this.inventory = inventory;
    }

    @Override
    public String execute(String instruction) {
        int row = this.worldMap.getPlayerRow();
        int col = this.worldMap.getPlayerCol();
        this.inventory.addItem(this.worldMap.getLocationAt(row, col).getItem());
        return "";
    }
}
