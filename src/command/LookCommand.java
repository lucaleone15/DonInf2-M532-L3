package command;

import main.WorldMap;

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
        this.worldMap.getLocationAt(row, col).getItem();
        return "";
    }
}

