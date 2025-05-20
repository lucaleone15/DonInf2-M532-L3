package main;

import item.Item;
import utils.IPrintable;

public class Location implements IPrintable {
    private String name;
    private String description;
    private boolean isLocked;
    private Item item;

    public Location(String name, String description, boolean isLocked, Item item) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        this.item = item;
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

    public void unlock() {
        this.isLocked = false;
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
