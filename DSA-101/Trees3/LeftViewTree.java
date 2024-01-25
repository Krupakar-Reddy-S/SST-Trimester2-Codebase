import java.util.ArrayList;

public class LeftViewTree {

    /* 
     * Companies: Microsoft, Adobe
     * 
     * Given a BT, return the left View of the BT
     * 
    */

    public static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
        levelOrder(root, result, 0);

        ArrayList<Integer> leftView = new ArrayList<>();

        for (ArrayList<Integer> level : result) {
            leftView.add(level.get(0));
        }

        return leftView;
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

        System.out.println(rootA);
        System.out.println(leftView(rootA));
    }
}
