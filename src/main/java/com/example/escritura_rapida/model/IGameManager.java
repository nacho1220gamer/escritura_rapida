package com.example.escritura_rapida.model;

/**
 * Defines the contract for managing the Fast Typing game logic.
 * <p>
 * This interface declares the methods required to control
 * the game's state, including levels, scores, and time per level.
 * </p>
 *
 * Implementations of this interface should provide the
 * underlying logic for word generation, score progression,
 * and game reset functionality.
 *
 * @author
 * @version 1.0
 */
public interface IGameManager {

    /**
     * Generates or retrieves the next word for the player.
     *
     * @return the next word to type, or {@code null} if no words remain.
     */
    String newWord();

    /**
     * Increases the current level and updates score/time accordingly.
     */
    void increaseLevel();

    /**
     * Gets the current level of the game.
     *
     * @return the current level number.
     */
    int getLevel();

    /**
     * Gets the current score of the player.
     *
     * @return the current score.
     */
    int getScore();

    /**
     * Gets the remaining time allocated per level.
     *
     * @return time per level in seconds.
     */
    int getTimePerLevel();

    /**
     * Resets the game to its initial state,
     * clearing progress and restoring default values.
     */
    void resetGame();
}
