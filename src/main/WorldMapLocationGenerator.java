package main;

import item.Key;
import item.Letter;

public class WorldMapLocationGenerator {

    public WorldMapLocationGenerator (){
    }

    public void generateWorldMapLocation(Location[][] map) {
        map[0][0] = new Location(
                "Village",
                "A peaceful little village.",
                false,
                new Key("tower", "An old iron key engraved with a tower symbol."),
                null
        );

        map[0][2] = new Location(
                "Tower",
                "An old mysterious tower.",
                true,
                new Letter("letter", "The more you take, the more you leave behind."),
                new Key("tower", "An old iron key engraved with a tower symbol.")
        );

        //Réponse : Footsteps

        map[1][0] = new Location(
                "Forest",
                "A dark and silent forest.",
                false,
                null,
                null
        );

        map[1][1] = new Location(
                "Crossroad",
                "A crossroad in the middle of nowhere.",
                false,
                null,
                null
        );

        map[1][2] = new Location(
                "Chapel",
                "An abandoned chapel.",
                false,
                null,
                null
        );

        map[2][1] = new Location(
                "Crypt",
                "A locked crypt full of secrets.",
                true,
                null,
                null
        );

        //Réponse : Echo
    }
}
