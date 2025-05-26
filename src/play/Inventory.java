package play;

import item.Item;
import item.Key;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }

    public Key getKey(String keyName) {
        for (Item items : itemList) {
            if (items.getName().equalsIgnoreCase(keyName)) {
                return null;
            }
        }
        return null; // si aucune clé ne correspond
    }

}
