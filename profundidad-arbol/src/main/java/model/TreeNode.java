package model;

public class TreeNode {
    private int valor;
    private TreeNode izquierda;
    private TreeNode derecha;

    public TreeNode() {}

    public TreeNode(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public TreeNode getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(TreeNode izquierda) {
        this.izquierda = izquierda;
    }

    public TreeNode getDerecha() {
        return derecha;
    }

    public void setDerecha(TreeNode derecha) {
        this.derecha = derecha;
    }
}
