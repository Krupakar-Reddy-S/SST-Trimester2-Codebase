public class IsSameTree {

    // TC = O(N), SC = O(log(N))    
    public static boolean isSame(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
    
        if (A == null || B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        boolean leftSame = isSame(A.left, B.left);
        boolean rightSame = isSame(A.right, B.right);

        return leftSame && rightSame;
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(8);
        rootA.left.left = new TreeNode(7);
        rootA.left.right = new TreeNode(6);
        rootA.right.left = new TreeNode(5);
        rootA.right.right = new TreeNode(4);

        TreeNode rootB = new TreeNode(10);
        rootB.left = new TreeNode(9);
        rootB.right = new TreeNode(8);
        rootB.left.left = new TreeNode(7);
        rootB.left.right = new TreeNode(6);
        rootB.right.left = new TreeNode(5);
        rootB.right.right = new TreeNode(4);

        System.out.println(isSame(rootA, rootB));
    }
}
