import java.util.ArrayList;
import java.util.Arrays;

public class LCA {

    public static TreeNode LCA_(TreeNode root, TreeNode N1, TreeNode N2) {
        if (root == null) {
            return null;
        }

        if (root == N1 || root == N2) {
            return root;
        }

        TreeNode left = LCA_(root.left, N1, N2);
        TreeNode right = LCA_(root.right, N1, N2);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2));
        TreeNode rootA = TreeNode.Deserialize(arr);

        System.out.println(rootA);
        System.out.println(LCA_(rootA, TreeNode.subTreeNode(rootA, 9), TreeNode.subTreeNode(rootA, -2)));
    }
}
