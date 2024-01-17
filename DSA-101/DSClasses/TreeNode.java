public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void preOrder() {
        preOrder(this);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(this, "", true, sb);
        return sb.toString();
    }

    private void printTree(TreeNode node, String prefix, boolean isTail, StringBuilder sb) {
        if (node.right != null) {
            printTree(node.right, prefix + (isTail && !prefix.isEmpty() ? "│   " : "    "), false, sb);
        }
        sb.append(prefix + (isTail ? "└── " : "┌── ") + node.val + "\n");
        if (node.left != null) {
            printTree(node.left, prefix + (!isTail && !prefix.isEmpty() ? "│   " : "    "), true, sb);
        }
    }
}
