public class InsertBST {

    /* 
     * given the root node of a binary search tree (BST) and a value to insert into the tree. 
     * Return the root node of the BST after the insertion. 
     * It is guaranteed that the new value does not exist in the original BST.
     * 
    */

    public static TreeNode insertBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
    
        if (root.val > val) {
            root.left = insertBST(root.left, val);
        }
        else {
            root.right = insertBST(root.right, val);
        }
    
        return root;
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(11);
        rootA.left.left = new TreeNode(8);
        rootA.left.right = new TreeNode(9);
        rootA.right.left = new TreeNode(10);
        rootA.right.right = new TreeNode(12);

        System.out.println(insertBST(rootA, 7));
    }
}
