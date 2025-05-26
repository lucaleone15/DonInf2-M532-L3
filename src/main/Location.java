package main;

import item.Item;
import item.Key;
import utils.IPrintable;

public class Location implements IPrintable {
    private String name;
    private String description;
    private boolean isLocked;
    private Item item;
    private Key requiredKey;

    public Location(String name, String description, boolean isLocked, Item item, Key requiredKey) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.item = item;
        this.requiredKey = requiredKey;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public Item getItem() {
        if (item == null) {
            System.out.println("No item in this location");
        }
        return this.item;
    }

    public boolean requiresKey() {
        return requiredKey != null;
    }

    public boolean canBeUnlockedWith(Key key) {
        return requiredKey != null && requiredKey.equals(key);
    }

    public void unlock() {
        this.isLocked = false;
        this.requiredKey = null;
    }

    @Override
    public String getPrintableString() {
        return "X";
    }

    @Override
    public boolean isGrayedOut() {
        return false;
    }
}
