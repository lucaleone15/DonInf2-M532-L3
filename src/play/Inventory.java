package play;

import command.TeleportCommand;
import item.Item;
import item.Key;
import main.WorldMap;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.*;

public class Inventory {
    private Map<String, Item> playerInventory = new HashMap<>();

    public void addItem(Item item) {
        if (item != null) {
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
            System.out.println(StringStyling.StyleString("You have no keys.", Style.BOLD, Color.WHITE));
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
            System.out.println(StringStyling.StyleString("You have no keys.", Style.BOLD, Color.WHITE));
        }
    }


    public void showInventory() {
        System.out.println(StringStyling.StyleString("Inventory:", Style.BOLD, Color.WHITE));
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

    public boolean hasItem(String name) {
        return playerInventory.containsKey(name);
    }

    public Map<String, Item> getPlayerInventory() {
        return this.playerInventory;
    }
}
