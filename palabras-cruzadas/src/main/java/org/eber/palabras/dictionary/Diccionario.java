package org.eber.palabras.dictionary;

import java.util.HashSet;
import java.util.Set;

public class Diccionario {
    private final Set<String> palabrasValidas;

    public Diccionario(String[] palabras) {
        this.palabrasValidas = new HashSet<>();
        for (String palabra : palabras) {
            palabrasValidas.add(palabra.toUpperCase());
        }
    }

    public boolean contiene(String palabra) {
        return palabrasValidas.contains(palabra);
    }
}
