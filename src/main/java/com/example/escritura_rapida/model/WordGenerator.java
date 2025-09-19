package com.example.escritura_rapida.model;

import java.util.*;

/**
 * Provides words for the Fast Typing game.
 * <p>
 * The {@code WordGenerator} maintains an internal shuffled list of words
 * to ensure that no word is repeated during a game session. Words are
 * returned sequentially from this shuffled list until all are exhausted.
 * </p>
 *
 * <p>
 * If all words are used, {@link #getRandomWord()} will return {@code null}.
 * The {@link #reset()} method can be called to reshuffle the word list
 * and start again from the beginning.
 * </p>
 *
 * <p>
 * This class uses static methods and fields so it can be accessed globally
 * without creating an instance.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class WordGenerator implements IWordProvider {

    private static final String[] WORDS = {
            // Short words (easy)
            "cat", "dog", "sun", "sky", "pen", "car", "cup", "map", "red", "blue",
            "green", "book", "ball", "star", "tree", "fish", "milk", "food", "door", "hand",

            // Medium words
            "school", "garden", "window", "future", "travel", "friend", "family",
            "letter", "study", "energy", "computer", "keyboard", "screen", "mouse",
            "teacher", "doctor", "driver", "summer", "winter", "nature",

            // Long words
            "university", "electricity", "programming", "mathematics", "technology",
            "imagination", "creativity", "intelligence",
            "experience", "knowledge", "organization", "development", "challenge",
            "adventure", "communication", "information", "environment", "happiness",
            "motivation",

            // More complex / advanced
            "extraordinary", "transformation", "collaboration", "conservation",
            "multiplication", "revolutionary", "independence", "sustainability",
            "infrastructure", "biotechnology", "understanding", "improvement",
            "achievement", "possibility", "application", "exceptional",
            "determination", "responsability", "professional", "international"
    };
    private static final List<String> wordList = new ArrayList<>(Arrays.asList(WORDS));
    private static int index = 0;

    public WordGenerator() {
        Collections.shuffle(wordList);
    }

    /**
     * Retrieves the next word in the shuffled list.
     *
     * @return the next available word, or {@code null} if no words remain.
     */
    @Override
    public String getRandomWord() {
        if (index >= wordList.size()) {
            return null; // No more words
        }
        return wordList.get(index++);
    }

    /**
     * Resets the word generator.
     * <p>
     * Shuffles the word list and resets the index to 0,
     * allowing the words to be reused in a new order.
     * </p>
     */
    @Override
    public void reset() {
        Collections.shuffle(wordList);
        index = 0;
    }


    /*
     * Legacy implementation:
     * Used random selection of words, which could result in repetition.
     * The new implementation avoids duplicates by shuffling and using an index.
     *
     * private static final Random random = new Random();
     *
     * public static String getRandomWord() {
     *     return WORDS[random.nextInt(WORDS.length)];
     * }
     */
}

