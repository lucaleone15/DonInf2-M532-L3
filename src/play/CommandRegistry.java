package play;

import command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    public void register(String keyword, Command command) {
        commands.put(keyword.toLowerCase(), command);
    }

    public String execute(String input) {

        String[] parts = input.strip().split(" ", 2);
        String keyword = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1] : "";

        Command command = commands.get(keyword);
        if (command == null && input != "save") {
            return "Unknown command: " + keyword;
        }

        return command.execute(args);
    }

    public Map<String, Command> getCommands() {
        for(Map. Entry<String, Command> commands : commands.entrySet()){
            System.out.println(commands.getKey() + ": " + commands.getValue().getDescription());
        }
        return commands;
    }
}
