package main;

import java.util.Random;

public class WorldMap {
    private Location[][] map;
    private int playerRow;
    private int playerCol;

    public WorldMap(int row, int col){
        map = new Location[row][col];
        this.generateMap();
    }

    private void generateMap() {
        map = new Location[10][10];

        map[0][0] = new Location("Village", "A peaceful starting village.", true, null);
        map[0][1] = new Location("Market", "A bustling market full of life.", false, null);
        map[0][2] = new Location("Bakery", "You smell fresh bread.", true, null);
        map[0][3] = new Location("Inn", "A cozy inn to rest.", false, null);
        map[0][4] = new Location("Blacksmith", "You hear the sound of hammering.", true, null);
        map[0][5] = new Location("Fountain", "A decorative water fountain.", true, null);
        map[0][6] = new Location("Shrine", "A sacred place of worship.", false, null);
        map[0][7] = new Location("Guard Post", "Guards are stationed here.", true, null);
        map[0][8] = new Location("Gate", "The main gate to the city.", true, null);
        map[0][9] = new Location("Field", "Open field for farming.", true, null);

        map[1][9] = new Location("Forest Edge", "The start of a dark forest.", true, null);
        map[2][9] = new Location("Forest Path", "Tall trees surround you.", true, null);
        map[3][9] = new Location("Old Cabin", "An abandoned wooden cabin.", false, null);
        map[4][9] = new Location("Deep Woods", "It's eerily quiet.", true, null);
        map[5][9] = new Location("Cave Entrance", "A dark hole in a hill.", true, null);
        map[5][8] = new Location("Cave", "It's cold and damp inside.", false, null);
        map[5][7] = new Location("Underground Lake", "A hidden water source.", true, null);
        map[5][6] = new Location("Crystal Chamber", "Walls glow faintly.", true, null);
        map[5][5] = new Location("Ancient Temple", "Covered in moss and vines.", true, null);
        map[5][4] = new Location("Ruins", "Crumbled stone structures.", false, null);

        map[4][4] = new Location("Campfire", "Signs of recent use.", true, null);
        map[3][4] = new Location("Watchtower", "You can see far from here.", true, null);
        map[2][4] = new Location("Bridge", "A stone bridge over a ravine.", true, null);
        map[1][4] = new Location("Riverbank", "Running water flows here.", true, null);
        map[1][3] = new Location("Fisherman's Hut", "A small wooden shack.", true, null);
        map[1][2] = new Location("Dock", "Boats are moored here.", true, null);
        map[1][1] = new Location("Storage", "Barrels and crates everywhere.", false, null);
        map[1][0] = new Location("Barn", "A big red barn.", true, null);

        map[2][0] = new Location("Stables", "Horses neigh nearby.", true, null);
        map[3][0] = new Location("Training Ground", "You hear clashing swords.", true, null);
        map[4][0] = new Location("Castle Gate", "The entry to a fortress.", true, null);
        map[4][1] = new Location("Castle Courtyard", "Guards patrol the area.", true, null);
        map[4][2] = new Location("Throne Room", "Ornate and majestic.", false, null);
        map[4][3] = new Location("Armory", "Weapons line the walls.", true, null);
        map[3][3] = new Location("Library", "Dusty tomes and scrolls.", true, null);
        map[2][3] = new Location("Alchemy Lab", "Strange smells linger.", true, null);
        map[2][2] = new Location("Kitchen", "Something's cooking.", true, null);
        map[2][1] = new Location("Dining Hall", "A large feast table stands.", true, null);

        map[3][1] = new Location("Garden", "Colorful flowers bloom.", true, null);
        map[3][2] = new Location("Maze", "Hedges form confusing paths.", false, null);
        map[5][3] = new Location("Shed", "A locked storage shed.", true, null);
        map[6][3] = new Location("Workshop", "Tools and machines everywhere.", true, null);
        map[6][4] = new Location("Observatory", "You can see the stars.", true, null);
        map[6][5] = new Location("Tower Base", "A tall structure begins here.", true, null);
        map[7][5] = new Location("Tower Top", "You have a clear view of the land.", true, null);
        map[7][4] = new Location("Balcony", "Wind whistles around you.", false, null);
        map[7][3] = new Location("Study", "Filled with maps and scrolls.", true, null);
        map[7][2] = new Location("Servants' Quarters", "Simple but tidy.", true, null);
        map[7][1] = new Location("Pantry", "Food is stocked here.", true, null);
        map[7][0] = new Location("Cellar", "Cool and dark underground room.", true, null);
    }


    public Location getLocation(int row, int column){
        return null;
    }

    public void addLocation(Location location, int row, int column){

    }
    public Location getPlayerLocation(){
        return null;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
    }

    public Location getLocationAt(int row, int col){
        return map[row][col];
    }

    public void setPlayerLocation(int row, int col){
        this.playerRow = row;
        this.playerCol = col;
    }

    public int getPlayerCol() {
        return this.playerCol;
    }

    public int getPlayerRow() {
        return this.playerRow;
    }

    public Location[][] getMap() {
        return this.map;
    }
}
