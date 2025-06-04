package item;

import item.Item;

public class Puzzle {
    private String riddle;
    private String answer;
    private Item reward;
    private boolean solved;

    public Puzzle(String riddle, String answer, Item reward) {
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

    public String getAnswer() {
        return this.answer;
    }

    public String getRiddle() {
        return riddle;
    }

    public Item getReward() {
        return reward;
    }
}
