package command;

import main.Location;
import main.WorldMap;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class MoveCommand extends Command implements ICommand {
    private WorldMap worldMap;

    public MoveCommand(String verb, String description, WorldMap worldMap) {
        super(verb, description);
        this.worldMap = worldMap;
    }

    @Override
    public String execute(String args) {
        if (args == null || args.isEmpty()) {
            return StringStyling.StyleString("Please specify a direction (north, south, east, west).", Style.BOLD, Color.WHITE);
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
                return StringStyling.StyleStringBright("Unknown direction. Use north, south, east or west.", Style.BOLD, Color.WHITE, Color.RED);
        }

        // Vérifie si la nouvelle position est valide
        if (!worldMap.isValidPosition(newRow, newCol)) {
            return StringStyling.StyleStringBright("Impossible to move there.", Style.BOLD, Color.WHITE, Color.RED);
        }

        Location destination = worldMap.getLocationAt(newRow, newCol);
        if (destination == null) {
            return StringStyling.StyleStringBright("Impossible to move there.", Style.BOLD, Color.WHITE, Color.RED);
        }

        if (destination.isLocked()) {
            return StringStyling.StyleString("Zone locked.", Style.BOLD, Color.RED);
        }

        // Déplacement réussi
        worldMap.setPlayerLocation(newRow, newCol);
        return destination.getDescription();
    }
}
