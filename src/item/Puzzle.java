package item;

import main.Location;

public class Puzzle {
    private String solution;
    Location location;
    Key key;

    public Puzzle (String solution, Location location, Key key){
        this.solution = solution;
        this.location = location;
        this.key = key;
    }

    public String getSolution() {
        return this.solution;
    }

    public Key getKey() {
        return this.key;
    }

    public Location getLocation() {
        return this.location;
    }
}
