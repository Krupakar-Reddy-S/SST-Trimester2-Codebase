import java.util.ArrayList;
import java.util.Arrays;

public class DiameterOfTree {

    /* 
     * Given a Binary Tree, return its Diameter.
     * The Diameter is defined as the maximum distance between any two nodes.
     * 
    */

    public static Pair<Integer, Integer> Diameter(TreeNode root) {
        if (root == null) {
            return new Pair<Integer, Integer>(-1, -1);
        }

        int height = Math.max(treeHeight(root.left), treeHeight(root.left)) + 1;
        int diameter = Math.max(treeHeight(root.left) + treeHeight(root.left), Math.max(Diameter(root.left).getValue(), Diameter(root.right).getValue()));

        return new Pair<Integer, Integer>(height, diameter);
    }

    public static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2));
        TreeNode rootA = TreeNode.Deserialize(arr);

        System.out.println(rootA);
        System.out.println(Diameter(rootA).getValue());
    }
}
