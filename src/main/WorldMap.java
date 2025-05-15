package main;

public class WorldMap {
    private Location[][] map;
    private int playerRow;
    private int playerCol;

    public WorldMap(int row, int col){
        map = new Location[row][col];

        map[5][0] = new Location("Village", "A peaceful village.", true);
        map[3][1] = new Location("Forest", "A dark forest.", false);
        map[11][10] = new Location("Lake", "A calm lake.", true);
        map[19][15] = new Location("Castle", "An ancient castle.", true);
    }

    public Location getLocation(int row, int column){
        return null;
    }

    public void addLocation(Location location, int row, int column){

    }
    public Location getPlayerLocation(){
        return null;
    }
    public void setPlayerLocation(int row, int column){

    }

    public int getPlayerCol() {
        return this.playerCol;
    }

    public int getPlayerRow() {
        return this.playerRow;
    }
}
