package command;

import main.WorldMap;

public class MoveCommand extends Command {
    WorldMap worldMap;

    public MoveCommand(WorldMap worldMap) {
    }

    @Override
    public String execute(String direction) {
        int col = worldMap.getPlayerCol();
        int row = worldMap.getPlayerRow();
        if (direction == "north"){
            worldMap.setPlayerLocation(row, col-1);
        } else if (direction == "east") {
            worldMap.setPlayerLocation(row+1, col);
        } else if (direction == "west") {
            worldMap.setPlayerLocation(row-1, col);
        } else if (direction == "south") {
            worldMap.setPlayerLocation(row, col+1);
        } else {
            System.out.println("Incorrect entry.");
        }
        return null;
    }
}