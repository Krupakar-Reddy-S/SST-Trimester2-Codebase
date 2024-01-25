public class IsBalancedBST {

    /* 
     * Given a BT, Check if it is Height Balanced.
     * A Tree is Height balanced if the absolute difference
     * between the Height(LeftSubTree) - Height(RightSubTree) <= 1
     * for every node in the tree.
     * 
    */

    // TC = O(N), SC = O(1)
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
    
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
    
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(5);
        rootA.right = new TreeNode(15);
        rootA.left.left = new TreeNode(2);
        rootA.left.right = new TreeNode(7);
        rootA.right.left = new TreeNode(12);
        rootA.right.right = new TreeNode(17);
        
        System.out.println(rootA);
        System.out.println("Is the tree balanced? " + isBalanced(rootA));

        TreeNode rootB = new TreeNode(10);
        rootB.left = new TreeNode(5);
        rootB.left.left = new TreeNode(2);
        rootB.left.left.left = new TreeNode(1);

        System.out.println(rootB);
        System.out.println("Is the tree balanced? " + isBalanced(rootB));
    }
}
