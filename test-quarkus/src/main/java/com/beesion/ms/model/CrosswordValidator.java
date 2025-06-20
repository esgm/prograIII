package com.beesion.ms.model;
import java.util.ArrayList;
import java.util.List;

public class CrosswordValidator {
    private char[][] board;
    private Dictionary dictionary;

    public CrosswordValidator(char[][] board, Dictionary dictionary) {
        this.board = board;
        this.dictionary = dictionary;
    }

    public boolean isValid() {
        return validateRows() && validateColumns();
    }

    private boolean validateRows() {
        for (char[] row : board) {
            if (!validateLine(row)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateColumns() {
        for (int col = 0; col < board.length; col++) {
            char[] column = new char[board.length];
            for (int row = 0; row < board.length; row++) {
                column[row] = board[row][col];
            }
            if (!validateLine(column)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateLine(char[] line) {
        StringBuilder word = new StringBuilder();
        for (char c : line) {
            if (c == '#') {
                if (word.length() >= 2 && !dictionary.isValidWord(word.toString())) {
                    return false;
                }
                word.setLength(0); // Reset the word
            } else {
                word.append(c);
            }
        }
        // Check the last word if the line ends without a '#'
        if (word.length() >= 2 && !dictionary.isValidWord(word.toString())) {
            return false;
        }
        return true;
    }
}
