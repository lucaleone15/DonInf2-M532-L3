package command;

import item.Letter;
public class InspectCommand extends Command implements ICommand {
    private Letter letter;
    public InspectCommand(String verb, String description, Letter letter) {
        super(verb, description);
        this.letter = letter;
    }

    @Override
    public String execute(String instruction) {
        return letter.getDescription();
    }
}
