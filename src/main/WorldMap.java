package main;

import java.util.Random;

public class WorldMap {
    private Location[][] map;
    private int playerRow;
    private int playerCol;

    public WorldMap(int row, int col){
        map = new Location[row][col];
        this.generateMap(row, col);

//        map[1][0] = new Location("aaaa", "bbbb", false);
//        map[5][0] = new Location("Village", "A peaceful village.", true);
//        map[3][1] = new Location("Forest", "A dark forest.", false);
//        map[11][10] = new Location("Lake", "A calm lake.", true);
//        map[19][15] = new Location("Castle", "An ancient castle.", true);
    }

    private void generateMap(int row, int col) {
        Random random = new Random();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                String description = "You are in zone " + r + "," + c;
                boolean locked = random.nextDouble() < 0.1; // 10% chance of locked zone
                map[r][c] = new Location("Location", description, locked);
            }
        }
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
}
