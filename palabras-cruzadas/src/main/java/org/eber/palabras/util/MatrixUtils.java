package org.eber.palabras.util;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {

    public static List<String> extraerPalabrasHorizontales(char[][] board) {
        List<String> palabras = new ArrayList<>();
        for (char[] fila : board) {
            palabras.addAll(extraerPalabrasDeLinea(new String(fila)));
        }
        return palabras;
    }

    public static List<String> extraerPalabrasVerticales(char[][] board) {
        List<String> palabras = new ArrayList<>();
        int n = board.length;
        for (int col = 0; col < n; col++) {
            StringBuilder columna = new StringBuilder();
            for (int row = 0; row < n; row++) {
                columna.append(board[row][col]);
            }
            palabras.addAll(extraerPalabrasDeLinea(columna.toString()));
        }
        return palabras;
    }

    private static List<String> extraerPalabrasDeLinea(String linea) {
        List<String> palabras = new ArrayList<>();
        String[] partes = linea.split("#");
        for (String parte : partes) {
            if (parte.length() >= 2) {
                palabras.add(parte);
            }
        }
        return palabras;
    }
}
