public class DeleteNode {

    /* 
     * Given a BST with distinct values & a number X.
     * Delete the node with value X.
     * 
    */

    // TC = O(Height of Tree), SC = O(Height of Tree)
    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } 
        else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } 
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } 
            else if (root.left == null) {
                root = root.right;
            } 
            else if (root.right == null) {
                root = root.left;
            } 
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }

        return root;
    }

    public static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        
        return node;
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
        rootA = deleteNode(rootA, 9);
        
        System.out.println(rootA);
        System.out.println(rootA.left.val); // 14, which means it is not a BST
    }
}
