package play;

import item.Item;
import item.Key;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Item> playerInventory = new HashMap<>();


    public void addItem(Item item){
        if (!(item == null)){
            playerInventory.put(item.getName(), item);
        }
    }

    public void removeItem(Item item){
        playerInventory.remove(item.getName());
    }

    public void removeItemByName(String name){
        playerInventory.remove(name);
    }

    public void showKeys() {
        if (playerInventory.isEmpty()) {
            System.out.println("You have no keys.");
            return;
        }
        boolean hasKey = false;
        for (String itemName : playerInventory.keySet()) {
            Item item = playerInventory.get(itemName);
            if (item instanceof Key) {
                System.out.println("- " + itemName + ": " + item.getDescription());
                hasKey = true;
            }
        }
        if (!hasKey) {
            System.out.println("You have no keys.");
        }
    }


    public void showInventory() {
        System.out.println("Inventory:");
        if (playerInventory.isEmpty()) {
            System.out.println(" - (empty)");
        } else {
            for (Item items : playerInventory.values()) {
                System.out.println(" - " + items.getName());
            }
        }
    }

    public Item getItem(String keyName) {
        if (playerInventory.containsKey(keyName)){
            return playerInventory.get(keyName);
        } else {
            return null;
        }
    }

    public Map<String, Item> getPlayerInventory() {
        return this.playerInventory;
    }
}
