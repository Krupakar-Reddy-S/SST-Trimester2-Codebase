import java.util.HashMap;

public class ConstructTree {

    /* 
     * Given the PreOrder & InOrder traversal of a binary tree 
     * (all values are distinct) Construct the tree.
     * 
    */

    public static TreeNode constructTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return constructTree(preOrder, inOrder, 0, inOrder.length - 1, 0, preOrder.length - 1, map);
    }

    public static TreeNode constructTree(int[] preOrder, int[] inOrder, int Is, int Ie, int Ps, int Pe, HashMap<Integer, Integer> map) {
        if (Ps > Pe) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[Ps]);
        int idx = map.get(preOrder[Ps]);
        int z = idx - Is;

        root.left = constructTree(preOrder, inOrder, Is, idx - 1, Ps + 1, Ps + z, map);
        root.right = constructTree(preOrder, inOrder, idx + 1, Ie, Ps + z + 1, Pe, map);

        return root;
    }

    public static void main(String[] args) {
        int preOrder[] = {3,9,20,15,7};
        int inOrder[] = {9,3,15,20,7};

        System.out.println(constructTree(preOrder, inOrder));
    }
}
