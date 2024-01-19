public class isMirrorTree {

    public static boolean isMirror(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
    
        if (A == null || B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        boolean leftSame = isMirror(A.left, B.right);
        boolean rightSame = isMirror(A.right, B.left);

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
        rootB.left = new TreeNode(8);
        rootB.right = new TreeNode(9);
        rootB.left.left = new TreeNode(6);
        rootB.left.right = new TreeNode(7);
        rootB.right.left = new TreeNode(4);
        rootB.right.right = new TreeNode(5);

        System.out.println(isMirror(rootA, rootB));
    }
}
