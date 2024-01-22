import java.util.ArrayList;

public class LevelOrderTraversal {

    /* 
     * Given a BT. Return the Level Order traversal
     * 
    */

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
        levelOrder(root, result, 0);
    
        return result;
    }

    public static void levelOrder(TreeNode root, ArrayList<ArrayList<Integer>> result, int depth) {
        if (root == null) {
            return;
        }
    
        if (depth == result.size()) {
            result.add(new ArrayList<Integer>());
        }
    
        result.get(depth).add(root.val);
    
        levelOrder(root.left, result, depth + 1);
        levelOrder(root.right, result, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(8);
        rootA.left.left = new TreeNode(7);
        rootA.left.right = new TreeNode(6);
        rootA.right.left = new TreeNode(5);
        rootA.right.right = new TreeNode(4);

        System.out.println(levelOrder(rootA));
    }
}
