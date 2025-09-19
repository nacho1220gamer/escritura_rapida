package com.example.escritura_rapida.model;

/**
 * Interface for providing words in the game.
 */
public interface IWordProvider {
    /**
     * Returns the next available word.
     *
     * @return the next word, or {@code null} if no words remain.
     */
    String getRandomWord();

    /**
     * Resets the word provider so that words can be reused.
     */
    void reset();
}
