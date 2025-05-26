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
        map = new Location[3][3];
        WorldMapLocationGenerator worldMapLocationGenerator = new WorldMapLocationGenerator();
        worldMapLocationGenerator.generateWorldMapLocation(map);
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
