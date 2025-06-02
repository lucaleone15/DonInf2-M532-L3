package main;

import item.Key;
import item.Letter;

public class WorldMapLocationGenerator {

    public WorldMapLocationGenerator() {
    }

    public void generateWorldMapLocation(Location[][] map) {
        map[0][0] = new Location("Village", "A peaceful village where your journey begins.", false, null, null);
        map[0][1] = new Location("Place maudite", "A fog-covered square. Whispers echo in the mist.", false, new Letter("A torn letter", "More you take, more you leave behind."), null);
        map[0][2] = new Location("Tour", "An old tower locked by an ancient mechanism.", true, null, new Key("tower", "A heavy iron key to open the ancient Tower."));
        map[0][3] = new Location("Falaises", "Steep cliffs drop into the abyss. Nothing to be found.", false, null, null);

        map[1][0] = new Location("Forêt", "A dense forest filled with eerie silence.", false, null, null);
        map[1][1] = new Location("Carrefour", "A crossroads with a rusty signpost pointing in all directions.", false, null, null);
        map[1][2] = new Location("Chapelle", "An abandoned chapel entangled in thorns.", false, new Letter("A faded note", "I speak without a mouth and hear without ears..."), null);
        map[1][3] = new Location("Grotte", "A damp cave with ancient carvings.", false, null, null);

        map[2][0] = new Location("Ruines", "Ancient ruins with strange symbols.", false, new Letter("A stone tablet", "What has keys but can't open locks?"), null);
        map[2][1] = new Location("Crypte", "A sealed crypt with a rusty lock.", true, null, new Key("crypt", "A rusty iron key engraved with the word 'crypt'."));
        map[2][2] = new Location("Pont effondré", "A collapsed bridge blocks the path. Nothing here.", false, null, null);
        map[2][3] = new Location("Sanctuaire", "A golden-doored sanctuary emanating silence.", true, null, new Key("sanctuary", "A polished silver key with music symbols."));

        map[3][0] = new Location("Lac", "A serene lake with something glimmering beneath.", false, new Letter("A wet scroll", "I have cities, but no houses. I have mountains, but no trees..."), null);
        map[3][1] = new Location("Cabane", "A near-collapsing wooden shack filled with scattered notes.", false, null, null);
        map[3][2] = new Location("Caverne scellée", "A cave sealed by an iron gate with glowing runes.", true, null, new Key("cave", "An ancient key shaped like a compass."));
        map[3][3] = new Location("Cimetière", "An overgrown graveyard covered in mist. Nothing of use here.", false, null, null);
    }
}