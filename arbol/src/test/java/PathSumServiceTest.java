import model.TreeNode;
import org.junit.jupiter.api.Test;
import service.PathSumService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathSumServiceTest {

    private final PathSumService service = new PathSumService();

    @Test
    void testFindPathsWithValidSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> paths = service.findPaths(root, 22);
        assertEquals(2, paths.size());
        assertTrue(paths.contains(List.of(5, 4, 11, 2)));
        assertTrue(paths.contains(List.of(5, 8, 4, 5)));
    }

    @Test
    void testFindPathsWithNoValidSum() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<List<Integer>> paths = service.findPaths(root, 5);
        assertTrue(paths.isEmpty());
    }
}
