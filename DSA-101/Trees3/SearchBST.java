public class SearchBST {

    /* 
     * Given the root of a binary search tree (BST) and an integer val.
     * Find the node in the BST that the node's value equals val and return 
     * the subtree rooted with that node. If such a node does not exist, return null.
     * 
    */

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(11);
        rootA.left.left = new TreeNode(8);
        rootA.left.right = new TreeNode(9);
        rootA.right.left = new TreeNode(10);
        rootA.right.right = new TreeNode(12);

        System.out.println(searchBST(rootA, 9));
    }
}
