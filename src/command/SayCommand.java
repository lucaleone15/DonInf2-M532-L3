package command;

import command.Command;
import command.ICommand;
import item.Puzzle;
import main.Location;
import main.WorldMap;
import play.Inventory;

import java.util.List;

public class SayCommand extends Command implements ICommand {
    private WorldMap worldMap;
    private Inventory inventory;
    private List<Puzzle> puzzles;

    public SayCommand(String verb, String description, WorldMap worldMap, Inventory inventory, List<Puzzle> puzzles) {
        super(verb, description);
        this.worldMap = worldMap;
        this.inventory = inventory;
        this.puzzles = puzzles;
    }

    @Override
    public String execute(String instruction) {
        for (Puzzle puzzle : puzzles) {
            if (!puzzle.isSolved()) {
                boolean success = puzzle.attempt(instruction);
                if (success) {
                    inventory.addItem(puzzle.getReward());
                    return "Correct! You solved the puzzle and obtained: " + puzzle.getReward().getName();
                }
            }
        }
        return "That's not the correct answer to any remaining puzzle.";
    }
}
