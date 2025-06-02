package play;

import command.Command;
import utils.Color;
import utils.StringStyling;
import utils.Style;

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

        if (command == null) {
            return StringStyling.StyleStringBright("Unknown command: " + keyword, Style.BOLD, Color.WHITE, Color.RED);
        }

        return command.execute(args);
    }

    public Map<String, Command> getCommands() {
        for(Map. Entry<String, Command> commands : commands.entrySet()){
            System.out.println(commands.getKey() + " : " + commands.getValue().getDescription());
        }
        return commands;
    }
}
