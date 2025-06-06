package command;

import main.Location;
import main.WorldMap;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Set;

public class MoveCommand extends Command implements ICommand {
    private WorldMap worldMap;
    private Set<String> visitedLocations;

    public MoveCommand(String verb, String description, WorldMap worldMap, Set<String> visitedLocations) {
        super(verb, description);
        this.worldMap = worldMap;
        this.visitedLocations = visitedLocations;
    }

    @Override
    public String execute(String args) {
        if (args == null || args.isEmpty()) {
            return StringStyling.StyleStringBright("You have to specify a direction (move <north / south / east / west>).", Style.BOLD, Color.WHITE, Color.RED);
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
            return StringStyling.StyleString("Impossible to move there.", Style.BOLD, Color.RED);
        }

        Location destination = worldMap.getLocationAt(newRow, newCol);
        if (destination == null) {
            return StringStyling.StyleString("Impossible to move there.", Style.BOLD, Color.RED);
        }

        if (destination.isLocked()) {
            return StringStyling.StyleString("Zone locked.", Style.BOLD, Color.RED);
        }

        // Déplacement réussi
        worldMap.setPlayerLocation(newRow, newCol);
        Location current = worldMap.getCurrentLocation();
        if (current != null) {
            visitedLocations.add(current.getName());
        }
        return destination.getDescription();
    }
}
