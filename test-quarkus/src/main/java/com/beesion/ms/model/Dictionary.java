package com.beesion.ms.model;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private Set<String> validWords;

    public Dictionary(Set<String> words) {
        this.validWords = new HashSet<>(words);
    }

    public boolean isValidWord(String word) {
        return validWords.contains(word);
    }
}
