package command;

import item.Puzzle;
import main.Location;
import main.WorldMap;

import java.util.List;

public class SayCommand extends Command implements ICommand{
    private List<Puzzle> puzzleList;
    private WorldMap worldMap;

    public SayCommand(String name, String description, List<Puzzle> puzzleList, WorldMap worldMap) {
        super(name, description);
        this.puzzleList = puzzleList;
        this.worldMap = worldMap;
    }

    @Override
    public String execute(String input) {
        for (Puzzle puzzle : puzzleList) {
            if (puzzle.tryAnswer(input)) {
                Location loc = worldMap.getLocationByName(puzzle.getTargetLocationName());
                if (loc == null) {
                    return "Error: target location '" + puzzle.getTargetLocationName() + "' not found.";
                }
                if (!loc.isLocked()) {
                    return "That riddle was already solved. The location is already open.";
                }
                loc.unlock();
                return "Correct! You solved the riddle. '" + loc.getName() + "' is now unlocked.";
            }
        }
        return "That doesn't seem to solve anything.";
    }
}

