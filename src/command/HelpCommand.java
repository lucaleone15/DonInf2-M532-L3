package command;

import play.CommandRegistry;

public class HelpCommand extends Command implements ICommand{
    private CommandRegistry commandRegistry;

    public HelpCommand(String name, String description, CommandRegistry commandRegistry) {
        super(name, description);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public String execute(String instruction) {
        commandRegistry.getCommands();
        return "";
    }
}
