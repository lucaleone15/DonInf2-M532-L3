package command;

public abstract class Command implements ICommand {
    private String description;
    private String verb;

    public Command(String verb, String description) {
        this.verb = verb;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVerb() {
        return this.verb;
    }
}
