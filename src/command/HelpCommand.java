package command;

import play.CommandRegistry;
import play.Inventory;

import java.util.stream.Collectors;

public class HelpCommand extends Command implements ICommand{
    private CommandRegistry commandRegistry;
    private Inventory inventory;

    public HelpCommand(String name, String description, CommandRegistry commandRegistry, Inventory inventory) {
        super(name, description);
        this.commandRegistry = commandRegistry;
        this.inventory = inventory;
    }

    @Override
    public String execute(String instruction) {
        return commandRegistry.getCommands().values().stream()
                .filter(cmd -> !(cmd instanceof TeleportCommand) || inventory.hasItem("Teleport Crystal"))
                .map(cmd -> cmd.getVerb() + ": " + cmd.getDescription())
                .collect(Collectors.joining("\n"));
    }

}
