package service;

import model.TreeNode;

public class TreeDepthService {

    public int calcularProfundidadMinima(TreeNode nodo) {
        if (nodo == null) return 0;

        if (nodo.getIzquierda() == null && nodo.getDerecha() == null) return 1;

        if (nodo.getIzquierda() == null) return calcularProfundidadMinima(nodo.getDerecha()) + 1;

        if (nodo.getDerecha() == null) return calcularProfundidadMinima(nodo.getIzquierda()) + 1;

        return Math.min(
                calcularProfundidadMinima(nodo.getIzquierda()),
                calcularProfundidadMinima(nodo.getDerecha())
        ) + 1;
    }

    public int calcularProfundidadMaxima(TreeNode nodo) {
        if (nodo == null) return 0;

        return Math.max(
                calcularProfundidadMaxima(nodo.getIzquierda()),
                calcularProfundidadMaxima(nodo.getDerecha())
        ) + 1;
    }
}
