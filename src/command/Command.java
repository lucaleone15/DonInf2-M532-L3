package command;

public abstract class Command {
    private String description;
    private String verb;

    public String getDescription() {
        return this.description;
    }

    public String getVerb() {
        return this.verb;
    }
}
