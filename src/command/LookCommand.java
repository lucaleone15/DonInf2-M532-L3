package command;

import item.Item;
import main.WorldMap;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class LookCommand extends Command implements ICommand{
    private WorldMap worldMap;

    public LookCommand(String name, String description, WorldMap worldMap) {
        super(name, description);
        this.worldMap = worldMap;
    }

    @Override
    public String execute(String instruction) {
        this.worldMap.getMap();
        int col = this.worldMap.getPlayerCol();
        int row = this.worldMap.getPlayerRow();
        if (!(this.worldMap.getLocationAt(row, col).getItem() == null)){
            System.out.println(StringStyling.StyleString("There is an item in this Location", Style.BOLD, Color.WHITE));
        }
        return "";
    }
}

