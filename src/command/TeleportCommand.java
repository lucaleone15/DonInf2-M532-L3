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

        if (instruction == null || instruction.trim().isEmpty()) {
            return "Please specify a location to teleport to.";
        }

        String destinationName = instruction.trim().toLowerCase();

        for (int row = 0; row < worldMap.getMap().length; row++) {
            for (int col = 0; col < worldMap.getMap()[0].length; col++) {
                Location loc = worldMap.getMap()[row][col];
                if (loc != null && loc.getName().trim().toLowerCase().equals(destinationName)) {
                    if (!visitedLocations.contains(loc.getName())) {
                        return "You haven't visited this location yet.";
                    }
                    worldMap.setPlayerLocation(row, col);
                    return "You teleported to " + loc.getName() + ".";
                }
            }
        }
        return "Unknown location.";
    }

}