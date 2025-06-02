package main;

import item.Key;
import item.Letter;

public class WorldMapLocationGenerator {

    public WorldMapLocationGenerator() {
    }

    public void generateWorldMapLocation(Location[][] map) {
        map[0][0] = new Location("Village", "A quiet starting village.", false, null, null);
        map[0][2] = new Location("Tower Gate", "A tall tower stands behind a locked gate.",
                true,
                null,
                new Key("tower", "A metallic key engraved with the image of a tower.")
        );

        map[1][0] = new Location("Abandoned Cabin", "An old cabin, the door creaks when opened.",
                false,
                new Letter("Cabin Note", "I have keys but no locks. I have space but no room. You can enter, but can’t go outside."),
                null
        );
        map[1][1] = new Location("Old Crossroads", "Dust swirls at this crossroads. It's eerily quiet.", false, null, null);
        map[1][2] = new Location("Ancient Shrine", "Moss-covered stones form a locked shrine.",
                true,
                null,
                new Key("shrine", "A smooth stone key with runic symbols carved in it.")
        );

        map[2][0] = new Location("Field", "An empty field with whispering winds.", false, null, null);
        map[2][1] = new Location("Chapel Ruins", "Broken stained glass crunches underfoot.",
                false,
                new Letter("Chapel Parchment", "The more you take, the more you leave behind."),
                null
        );
        map[2][2] = new Location("Crypt Entrance", "A heavy stone door blocks the crypt.",
                true,
                null,
                new Key("crypt", "A rusty iron key with a skull engraved on its handle.")
        );
    }
}