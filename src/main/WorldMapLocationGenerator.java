package main;

public class WorldMapLocationGenerator {

    public WorldMapLocationGenerator (){
    }

    public void generateWorldMapLocation(Location map[][]){
        // Emplacement de départ du joueur
        map[0][0] = new Location("Village", "A peaceful starting village.", true, null); // ouverte

        // Une seule autre accessible
        map[0][1] = new Location("Path", "A narrow path leading into the forest.", true, null); // ouverte

        // Verrouillées
        map[1][0] = new Location("Forest", "Thick trees block your path.", false, null); // fermée
        map[1][1] = new Location("Ruins", "Collapsed ruins. Entry is blocked.", false, null); // fermée
        map[2][1] = new Location("Lake", "A serene lake. The bridge is broken.", false, null); // fermée
    }
}
