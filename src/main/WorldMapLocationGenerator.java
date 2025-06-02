package main;

import item.Item;
import item.Key;
import item.Letter;

public class WorldMapLocationGenerator {

    public WorldMapLocationGenerator() {
    }

    public void generateWorldMapLocation(Location[][] map) {
        map[0][0] = new Location("Village", "A peaceful village where your journey begins.", false, null, null);
        map[0][1] = new Location("Cursed Square", "A fog-covered square. Whispers echo in the mist.", false, new Letter("A torn letter", "More you take, more you leave behind."), null);
        map[0][2] = new Location("Tower", "An old tower locked by an ancient mechanism.", true, null, new Key("tower", "A heavy iron key to open the ancient Tower."));
        map[0][3] = new Location("Cliffs", "Steep cliffs drop into the abyss. Nothing to be found.", false, null, null);

        map[1][0] = new Location("Forest", "A dense forest filled with eerie silence.", false, new Item("Teleport Crystal", "A glowing crystal that allows teleportation to visited locations."), null);
        map[1][1] = new Location("Crossroads", "A crossroads with a rusty signpost pointing in all directions.", false, null, null);
        map[1][2] = new Location("Chapel", "An abandoned chapel entangled in thorns.", false, new Letter("A faded note", "I speak without a mouth and hear without ears..."), null);
        map[1][3] = new Location("Cave", "A damp cave with ancient carvings.", false, null, null);

        map[2][0] = new Location("Ruins", "Ancient ruins with strange symbols.", false, new Letter("A stone tablet", "What has keys but can't open locks?"), null);
        map[2][1] = new Location("Crypt", "A sealed crypt with a rusty lock.", true, null, new Key("crypt", "A rusty iron key engraved with the word 'crypt'."));
        map[2][2] = new Location("Collapsed Bridge", "A collapsed bridge blocks the path. Nothing here.", false, null, null);
        map[2][3] = new Location("Sanctuary", "A golden-doored sanctuary emanating silence.", true, null, new Key("sanctuary", "A polished silver key with music symbols."));

        map[3][0] = new Location("Lake", "A serene lake with something glimmering beneath.", false, new Letter("A wet scroll", "I have cities, but no houses. I have mountains, but no trees..."), null);

        map[3][1] = new Location(
                "Cabin",
                "A near-collapsing wooden shack filled with scattered notes. Something magical glows faintly here.",
                false,
                new Item("Teleport Crystal", "A glowing crystal that allows teleportation to visited locations."),
                null
        );

        map[3][2] = new Location("Sealed Cavern", "A cave sealed by an iron gate with glowing runes.", true, new Key("FinalKey", "The ultimate key to finish your quest."), new Key("cave", "An ancient key shaped like a compass."));
        map[3][3] = new Location("Cemetery", "An overgrown graveyard covered in mist. Nothing of use here.", false, null, null);
    }

}