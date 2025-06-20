package org.eber.palabras.service;

import org.eber.palabras.dictionary.Diccionario;
import org.eber.palabras.util.MatrixUtils;

import java.util.List;

public class PalabraValidatorService {

    public boolean validar(char[][] board, String[] diccionarioArray) {
        Diccionario diccionario = new Diccionario(diccionarioArray);
        List<String> horizontales = MatrixUtils.extraerPalabrasHorizontales(board);
        List<String> verticales = MatrixUtils.extraerPalabrasVerticales(board);

        return validarTodas(horizontales, diccionario) && validarTodas(verticales, diccionario);
    }

    private boolean validarTodas(List<String> palabras, Diccionario diccionario) {
        for (String palabra : palabras) {
            if (!diccionario.contiene(palabra)) {
                return false;
            }
        }
        return true;
    }
}
