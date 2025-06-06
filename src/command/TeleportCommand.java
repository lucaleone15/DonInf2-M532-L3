package command;

import item.Item;
import main.Location;
import main.WorldMap;
import play.Inventory;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Set;

public class TeleportCommand extends Command implements ICommand {
    private WorldMap worldMap;
    private Inventory inventory;
    private Set<String> visitedLocations;

    public TeleportCommand(String verb, String description, WorldMap worldMap, Inventory inventory, Set<String> visitedLocations) {
        super(verb, description);
        this.worldMap = worldMap;
        this.inventory = inventory;
        this.visitedLocations = visitedLocations;
    }

    @Override
    public String execute(String instruction) {
        if (!inventory.hasItem("Teleport Crystal")) {
            return StringStyling.StyleStringBright("You need the Teleport Crystal to use this command.", Style.BOLD, Color.WHITE, Color.RED);
        }

        if (visitedLocations.isEmpty()) {
            return StringStyling.StyleString("You have not visited any locations yet.", Style.BOLD, Color.WHITE);
        }

        // Affiche la liste des lieux visités
        StringBuilder sb = new StringBuilder(StringStyling.StyleString("Visited locations :\n", Style.BOLD, Color.WHITE));
        for (String locName : visitedLocations) {
            sb.append("- ").append(locName).append("\n");
        }

        // Si aucune destination spécifiée, on affiche la liste et demande la destination
        if (instruction == null || instruction.trim().isEmpty()) {
            sb.append(StringStyling.StyleStringBright("You have to specify a location to teleport to (teleport <location>.", Style.BOLD, Color.WHITE, Color.RED));
            return sb.toString();
        }

        String destinationName = instruction.trim().toLowerCase();

        // Vérifie si la destination est visitée (ignore casse)
        boolean visited = false;
        for (String visitedLoc : visitedLocations) {
            if (visitedLoc.equalsIgnoreCase(destinationName)) {
                visited = true;
                break;
            }
        }
        if (!visited) {
            return sb.toString() + StringStyling.StyleString("You haven't visited this location yet.", Style.BOLD, Color.WHITE);
        }

        // Cherche la location dans la map
        for (int row = 0; row < worldMap.getMap().length; row++) {
            for (int col = 0; col < worldMap.getMap()[0].length; col++) {
                Location loc = worldMap.getMap()[row][col];
                if (loc != null && loc.getName().trim().equalsIgnoreCase(destinationName)) {
                    worldMap.setPlayerLocation(row, col);
                    return sb.toString() + StringStyling.StyleString("You teleported to " + loc.getName() + ".", Style.BOLD, Color.GREEN);
                }
            }
        }

        return sb.toString() + StringStyling.StyleStringBright("Unknown location.", Style.BOLD, Color.WHITE, Color.RED);
    }
}
