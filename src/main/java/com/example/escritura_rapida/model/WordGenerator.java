package com.example.escritura_rapida.model;

import java.util.*;

public class WordGenerator {

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
            "imagination", "responsibility", "creativity", "intelligence",
            "experience", "knowledge", "organization", "development", "challenge",
            "adventure", "communication", "information", "environment", "happiness",
            "motivation",

            // More complex / advanced
            "extraordinary", "transformation", "collaboration", "conservation",
            "multiplication", "revolutionary", "independence", "sustainability",
            "infrastructure", "biotechnology", "understanding", "improvement",
            "achievement", "possibility", "application", "exceptional",
            "determination", "responsibility", "professional", "international"
    };
    private static final List<String> wordList = new ArrayList<>(Arrays.asList(WORDS));
    private static int index = 0;

    static {
        Collections.shuffle(wordList);
    }

    public static String getRandomWord() {
        if (index >= wordList.size()) {
            return null; // No more words
        }
        return wordList.get(index++);
    }

    public static void reset() {
        Collections.shuffle(wordList);
        index = 0;
    }


    // private static final Random random = new Random();

    // public static String getRandomWord() {
    //    return WORDS[random.nextInt(WORDS.length)];
    // }
}

