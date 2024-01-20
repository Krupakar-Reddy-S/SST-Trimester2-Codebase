public class CountNodes {

    /* 
     * Count the No. of Nodes in the tree and return it.
     * 
    */

    // TC = O(N), SC = O(log(N))
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(8);
        rootA.left.left = new TreeNode(7);
        rootA.left.right = new TreeNode(6);
        rootA.right.left = new TreeNode(5);
        rootA.right.right = new TreeNode(4);

        System.out.println(countNodes(rootA));
    }
}
