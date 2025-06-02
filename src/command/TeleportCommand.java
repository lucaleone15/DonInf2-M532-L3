package command;

import item.Item;
import main.Location;
import main.WorldMap;
import play.Inventory;

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
            return "You need the Teleport Crystal to use this command.";
        }

        if (visitedLocations.isEmpty()) {
            return "You have not visited any locations yet.";
        }

        // Affiche la liste des lieux visités
        StringBuilder sb = new StringBuilder("Visited locations:\n");
        for (String locName : visitedLocations) {
            sb.append("- ").append(locName).append("\n");
        }

        // Si aucune destination spécifiée, on affiche la liste et demande la destination
        if (instruction == null || instruction.trim().isEmpty()) {
            sb.append("Please specify a location to teleport to.");
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
            return sb.toString() + "You haven't visited this location yet.";
        }

        // Cherche la location dans la map
        for (int row = 0; row < worldMap.getMap().length; row++) {
            for (int col = 0; col < worldMap.getMap()[0].length; col++) {
                Location loc = worldMap.getMap()[row][col];
                if (loc != null && loc.getName().trim().equalsIgnoreCase(destinationName)) {
                    worldMap.setPlayerLocation(row, col);
                    return sb.toString() + "You teleported to " + loc.getName() + ".";
                }
            }
        }

        return sb.toString() + "Unknown location.";
    }
}
