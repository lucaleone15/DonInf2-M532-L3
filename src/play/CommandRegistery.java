package play;

import command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistery {

    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public List<Command> getCommandList() {
        return commandList;
    }
}
