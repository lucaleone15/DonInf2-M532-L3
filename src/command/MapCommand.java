package command;

import main.WorldMap;
import utils.Array2Dprinter;

public class MapCommand extends Command implements ICommand{
    private WorldMap worldMap;

    public MapCommand (String verb, String description, WorldMap worldMap) {
        super(verb, description);
        this.worldMap = worldMap;
    }

    @Override
    public String execute(String instruction) {
        return Array2Dprinter.print2DArray(worldMap.getMap(), worldMap.getPlayerRow(), worldMap.getPlayerCol());
    }
}
