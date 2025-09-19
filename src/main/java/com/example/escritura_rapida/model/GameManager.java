package com.example.escritura_rapida.model;

/**
 * Manages the core logic of the Fast Typing game.
 * <p>
 * This class keeps track of the game state, including the
 * current level, score, and available time per level.
 * It also provides methods to generate new words, update
 * progress, and reset the game.
 * </p>
 *
 * <p>
 * The {@link GameManager} works together with
 * {@link WordGenerator} to supply words to the player.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class GameManager implements IGameManager {
    private int level;
    private int score;
    private int timePerLevel;

    private IWordProvider wordProvider;

    /**
     * Constructs a new {@code GameManager} with the initial state:
     * <ul>
     *     <li>Level = 1</li>
     *     <li>Score = 0</li>
     *     <li>Time per level = 20 seconds</li>
     * </ul>
     */
    public GameManager() {
        this.level = 1;
        this.score = 0;
        this.timePerLevel = 20;
        this.wordProvider = new WordGenerator();
    }

    /**
     * Generates a new word for the current level.
     * <p>
     * Uses {@link WordGenerator} to retrieve the next available word.
     * </p>
     *
     * @return the next word to type, or {@code null} if no words remain.
     */
    @Override
    public String newWord() {
        return wordProvider.getRandomWord();
    }

    /**
     * Increases the game level and updates the score.
     * <p>
     * Each new level adds 10 points to the score.
     * Every 5 levels, the time per level is reduced by 2 seconds
     * (with a minimum limit of 2 seconds).
     * </p>
     */
    @Override
    public void increaseLevel() {
        this.level++;
        score += 10;
        if (this.level % 5 == 0 && timePerLevel > 2) {
            timePerLevel -= 2;
        }
    }

    /**
     * Returns the current level.
     *
     * @return the current level number.
     */
    @Override
    public int getLevel() {
        return level;
    }
    /**
     * Returns the current score.
     *
     * @return the player's score.
     */
    @Override
    public int getScore() {
        return score;
    }
    /**
     * Returns the time allowed per level.
     *
     * @return time in seconds.
     */
    @Override
    public int getTimePerLevel() {
        return timePerLevel;
    }

    /**
     * Resets the game state to its initial values.
     * <ul>
     *     <li>Level = 1</li>
     *     <li>Score = 0</li>
     *     <li>Time per level = 20 seconds</li>
     * </ul>
     */
    @Override
    public void resetGame() {
        level = 1;
        score = 0;
        timePerLevel = 20;
        wordProvider.reset();
    }
}
