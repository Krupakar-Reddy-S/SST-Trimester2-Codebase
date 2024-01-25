public class CheckIfBST {

    /* 
     * Given a BT. Check if the BT is a BST
     * 
    */

    // TC = O(N), SC = O(Height of Tree)
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(11);
        rootA.left.left = new TreeNode(7);
        rootA.left.right = new TreeNode(14);
        rootA.right.left = new TreeNode(8);
        rootA.right.right = new TreeNode(13);

        System.out.println(rootA);
        System.out.println(isValidBST(rootA));

        TreeNode rootB = new TreeNode(11);
        rootB.left = new TreeNode(6);
        rootB.right = new TreeNode(15);

        rootB.left.left = new TreeNode(2);
        rootB.left.right = new TreeNode(9);
        rootB.left.right.left = new TreeNode(13);

        rootB.right.left = new TreeNode(7);
        rootB.right.right = new TreeNode(21);
        rootB.right.right.left = new TreeNode(18);
        rootB.right.right.left.left = new TreeNode(16);

        System.out.println(rootB);
        System.out.println(isValidBST(rootB));

        TreeNode rootC = new TreeNode(10);
        rootC.left = new TreeNode(5);
        rootC.right = new TreeNode(20);

        rootC.left.left = new TreeNode(2);
        rootC.left.right = new TreeNode(7);
        rootC.left.right.left = new TreeNode(6);
        rootC.left.right.right = new TreeNode(8);

        rootC.right.right = new TreeNode(22);
        rootC.right.right.left = new TreeNode(21);
        rootC.right.right.right = new TreeNode(50);

        System.out.println(rootC);
        System.out.println(isValidBST(rootC));

        TreeNode rootD = new TreeNode(5);
        rootD.right = new TreeNode(8);
        rootD.left = new TreeNode(1);
        rootD.left.right = new TreeNode(6);

        System.out.println(rootD);
        System.out.println(isValidBST(rootD));
    }
}
