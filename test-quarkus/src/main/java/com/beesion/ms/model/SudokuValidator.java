package com.beesion.ms.model;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    /**
     * Valida si un tablero de Sudoku es válido.
     *
     * @param board un arreglo 2D que representa el tablero de Sudoku
     * @return true si el tablero es válido, false en caso contrario
     */
    public boolean isValidSudoku(char[][] board) {
        // Validar filas y columnas
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }

        // Validar subcuadrantes 3x3
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValidSubgrid(board, row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> seen = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            char num = board[row][col];
            if (num != '.') {
                if (!seen.add(num)) {
                    return false; // Duplicado encontrado
                }
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> seen = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            char num = board[row][col];
            if (num != '.') {
                if (!seen.add(num)) {
                    return false; // Duplicado encontrado
                }
            }
        }
        return true;
    }

    private boolean isValidSubgrid(char[][] board, int startRow, int startCol) {
        Set<Character> seen = new HashSet<>();
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                char num = board[row][col];
                if (num != '.') {
                    if (!seen.add(num)) {
                        return false; // Duplicado encontrado
                    }
                }
            }
        }
        return true;
    }
}
