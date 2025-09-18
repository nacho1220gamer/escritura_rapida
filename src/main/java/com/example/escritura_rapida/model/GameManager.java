package com.example.escritura_rapida.model;

public class GameManager {
    private int level;
    private int score;
    private int timePerLevel;

    public GameManager() {
        this.level = 1;
        this.score = 0;
        this.timePerLevel = 20;
    }

    public String newWord() {
        return WordGenerator.getRandomWord();
    }

    public void increaseLevel() {
        this.level++;
        score += 10;
        if (this.level % 5 == 0 && timePerLevel > 2) {
            timePerLevel -= 2;
        }
    }

    public int getLevel() {
        return level;
    }
    public int getScore() {
        return score;
    }
    public int getTimePerLevel() {
        return timePerLevel;
    }

    public void resetGame() {
        level = 1;
        score = 0;
        timePerLevel = 20;
    }
}
