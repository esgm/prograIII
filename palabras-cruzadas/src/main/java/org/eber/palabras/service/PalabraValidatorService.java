package org.eber.palabras.service;

public class PalabraValidatorService {

    public boolean validar(char[][] board, String[] diccionario) {
        for (String palabra : diccionario) {
            if (!buscarPalabra(board, palabra)) {
                return false; // Si alguna palabra no se encuentra, retorna false
            }
        }
        return true; // Todas las palabras fueron encontradas
    }

    private boolean buscarPalabra(char[][] board, String palabra) {
        int filas = board.length;
        int columnas = board[0].length;

        // Buscar en cada celda del tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (board[i][j] == palabra.charAt(0)) {
                    // Buscar en todas las direcciones
                    if (buscarEnDirecciones(board, palabra, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false; // Si no se encuentra la palabra
    }

    private boolean buscarEnDirecciones(char[][] board, String palabra, int fila, int columna) {
        // Direcciones: horizontal, vertical, diagonal
        int[][] direcciones = {
                {0, 1},  // Derecha
                {1, 0},  // Abajo
                {1, 1},  // Diagonal derecha abajo
                {0, -1}, // Izquierda
                {-1, 0}, // Arriba
                {-1, -1}, // Diagonal izquierda arriba
                {-1, 1},  // Diagonal derecha arriba
                {1, -1}   // Diagonal izquierda abajo
        };

        for (int[] dir : direcciones) {
            if (buscarEnDireccion(board, palabra, fila, columna, dir[0], dir[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean buscarEnDireccion(char[][] board, String palabra, int fila, int columna, int dirX, int dirY) {
        int longitud = palabra.length();
        for (int k = 0; k < longitud; k++) {
            int nuevaFila = fila + k * dirX;
            int nuevaColumna = columna + k * dirY;

            // Verificar límites
            if (nuevaFila < 0 || nuevaFila >= board.length || nuevaColumna < 0 || nuevaColumna >= board[0].length) {
                return false;
            }

            // Comparar caracteres
            if (board[nuevaFila][nuevaColumna] != palabra.charAt(k)) {
                return false;
            }
        }
        return true; // La palabra fue encontrada en esta dirección
    }
}
