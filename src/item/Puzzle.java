package item;

import main.Location;

public class Puzzle {
    private String question;
    private String answer;
    private String targetLocationName;

    public Puzzle(String question, String answer, String targetLocationName) {
        this.question = question;
        this.answer = answer.toLowerCase(); // pour simplifier la comparaison
        this.targetLocationName = targetLocationName;
    }

    public boolean tryAnswer(String playerAnswer) {
        return this.answer.equals(playerAnswer.toLowerCase());
    }

    public String getTargetLocationName() {
        return this.targetLocationName;
    }

    public String getQuestion() {
        return this.question;
    }
}
