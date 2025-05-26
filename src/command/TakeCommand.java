package command;

import item.Item;
import main.WorldMap;
import play.Inventory;

public class TakeCommand extends Command implements ICommand{
    private WorldMap worldMap;
    private Inventory inventory;

    public TakeCommand(String verb, String description, WorldMap worldMap) {
        super(verb, description);
        this.worldMap = worldMap;
    }

    @Override
    public String execute(String instruction) {
        int row = this.worldMap.getPlayerRow();
        int col = this.worldMap.getPlayerCol();
        this.inventory.addItem(this.worldMap.getLocationAt(row, col).getItem());
        return "";
    }
}
