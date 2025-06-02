package command;

import item.Item;
import main.WorldMap;
import play.Inventory;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.awt.*;

public class TakeCommand extends Command implements ICommand{
    private WorldMap worldMap;
    private Inventory inventory;

    public TakeCommand(String verb, String description, WorldMap worldMap, Inventory inventory) {
        super(verb, description);
        this.worldMap = worldMap;
        this.inventory = inventory;
    }

    @Override
    public String execute(String instruction) {
        int row = this.worldMap.getPlayerRow();
        int col = this.worldMap.getPlayerCol();
        if (!(this.worldMap.getLocationAt(row, col).getItem() == null)){
            this.inventory.addItem(this.worldMap.getLocationAt(row, col).getItem());
            this.worldMap.getLocationAt(row, col).removeItem();
            System.out.println(StringStyling.StyleString("The object has been added to your inventory.", Style.BOLD, Color.WHITE));
        }
        return "";
    }
}
