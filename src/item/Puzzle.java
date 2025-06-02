package item;

import item.Item;

public class Puzzle {
    private String locationName; // le nom de la zone concernée
    private String riddle;
    private String answer;
    private Item reward;
    private boolean solved;

    public Puzzle(String locationName, String riddle, String answer, Item reward) {
        this.locationName = locationName;
        this.riddle = riddle;
        this.answer = answer.toLowerCase(); // pour comparaison insensible à la casse
        this.reward = reward;
        this.solved = false;
    }

    public boolean attempt(String response) {
        if (!solved && response.toLowerCase().equals(answer)) {
            solved = true;
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        return solved;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getRiddle() {
        return riddle;
    }

    public Item getReward() {
        return reward;
    }
}
