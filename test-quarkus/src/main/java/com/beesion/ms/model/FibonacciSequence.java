package com.beesion.ms.model;

public class FibonacciSequence {

    /**
     * Genera una secuencia de Fibonacci personalizada.
     * @param signature arreglo con dos números iniciales de la secuencia
     * @param n cantidad de elementos a devolver
     * @return arreglo con los primeros n elementos de la secuencia
     */
    public static int[] fibonacci(int[] signature, int n) {
        if (n == 0) {
            return new int[0];
        }
        if (n == 1) {
            return new int[] { signature[0] };
        }

        int[] result = new int[n];
        result[0] = signature[0];
        result[1] = signature[1];

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        return result;
    }
}
