package org.eber.palabras.model;

public class BoardRequest {
    public char[][] board;
    public String[] diccionario;

    // Constructor público
    public BoardRequest() {}

    // Getters y Setters
    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public String[] getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(String[] diccionario) {
        this.diccionario = diccionario;
    }
}
