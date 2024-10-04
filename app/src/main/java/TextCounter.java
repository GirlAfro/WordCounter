package com.example.wordcounter;

public class TextCounter {
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("[\\s,.]+");
        return words.length;
    }

    public static int countCharacters(String text) {
        return text != null ? text.length() : 0;
    }
}
