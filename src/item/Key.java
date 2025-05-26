package item;

import main.Location;

public class Key extends Item{
    private Location location;

    public Key (String name, String description, Location location){
        super(name, description);
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Key)) return false;
        Key other = (Key) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
