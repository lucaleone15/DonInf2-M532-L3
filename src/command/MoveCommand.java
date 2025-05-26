package command;

import main.Location;
import main.WorldMap;

public class MoveCommand extends Command implements ICommand {
    private WorldMap worldMap;

    public MoveCommand(String verb, String description, WorldMap worldMap) {
        super(verb, description);
        this.worldMap = worldMap;
    }

    @Override
    public String execute(String args) {
        if (args == null || args.isEmpty()) {
            return "Please specify a direction (north, south, east, west).";
        }

        int currentRow = worldMap.getPlayerRow();
        int currentCol = worldMap.getPlayerCol();
        int newRow = currentRow;
        int newCol = currentCol;

        // Détermination de la nouvelle position en fonction de la direction
        switch (args.toLowerCase()) {
            case "north":
                newRow = currentRow - 1;
                break;
            case "south":
                newRow = currentRow + 1;
                break;
            case "east":
                newCol = currentCol + 1;
                break;
            case "west":
                newCol = currentCol - 1;
                break;
            default:
                return "Unknown direction. Use north, south, east or west.";
        }

        // Vérifie si la nouvelle position est valide
        if (!worldMap.isValidPosition(newRow, newCol)) {
            return "Impossible to move there.";
        }

        Location destination = worldMap.getLocationAt(newRow, newCol);
        if (destination == null) {
            return "Impossible to move there.";
        }

        if (destination.isLocked()) {
            return "Zone locked.";
        }

        // Déplacement réussi
        worldMap.setPlayerLocation(newRow, newCol);
        return destination.getDescription();
    }
}
