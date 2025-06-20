package service;

import model.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeDepthServiceTest {

    TreeDepthService service = new TreeDepthService();

    @Test
    public void testProfundidades() {
        TreeNode root = new TreeNode(1);
        root.izquierda = new TreeNode(2);
        root.derecha = new TreeNode(3);
        root.izquierda.izquierda = new TreeNode(4);
        root.izquierda.derecha = new TreeNode(5);

        int min = service.calcularProfundidadMinima(root);  // 2 (1 -> 3)
        int max = service.calcularProfundidadMaxima(root);  // 3 (1 -> 2 -> 4 o 5)

        assertEquals(2, min);
        assertEquals(3, max);
    }

    @Test
    public void testArbolVacio() {
        assertEquals(0, service.calcularProfundidadMinima(null));
        assertEquals(0, service.calcularProfundidadMaxima(null));
    }
}
