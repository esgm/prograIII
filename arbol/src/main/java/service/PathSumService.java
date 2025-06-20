package service;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de encontrar todas las rutas desde la raíz hasta las hojas que suman un valor objetivo.
 */
public class PathSumService {

    /**
     * Encuentra todas las rutas válidas desde la raíz hasta hojas que suman targetSum.
     * @param root Nodo raíz del árbol binario.
     * @param targetSum Suma objetivo.
     * @return Lista de rutas válidas.
     */
    public List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), paths);
        return paths;
    }

    private void backtrack(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) return;

        currentPath.add(node.val);

        // Verifica si es una hoja y suma correcta
        if (node.left == null && node.right == null && node.val == remainingSum) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            backtrack(node.left, remainingSum - node.val, currentPath, allPaths);
            backtrack(node.right, remainingSum - node.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1); // backtrack
    }
}