package main;

public class Location {
    private String name;
    private String description;
    private boolean isLocked;

    public Location(String name, String description, boolean isLocked) {
        this.name = name;
        this.description  = description;
        this.isLocked = isLocked;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLocked(){
        return this.isLocked;
    }

    public void unlock(){
        this.isLocked = false;
    }
}
