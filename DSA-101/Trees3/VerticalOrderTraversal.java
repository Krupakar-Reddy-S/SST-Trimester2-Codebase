import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {

    /* 
     * Companies: Microsoft, Adobe
     * 
     * Given a BT, return its Vertical Order traversal
     * 
    */
    
    public static ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, ArrayList<int[]>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, int[]>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, new int[]{0, 0}));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, ArrayList<int[]>> tempMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, int[]> current = queue.poll();
                TreeNode node = current.getKey();
                int[] info = current.getValue();
                int row = info[0];
                int col = info[1];

                tempMap.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, new int[]{row + 1, col - 1}));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, new int[]{row + 1, col + 1}));
                }
            }

            for (Map.Entry<Integer, ArrayList<int[]>> entry : tempMap.entrySet()) {
                int col = entry.getKey();
                ArrayList<int[]> nodes = entry.getValue();
                columnMap.computeIfAbsent(col, k -> new ArrayList<>()).addAll(nodes);
            }
        }

        ArrayList<Integer> sortedColumns = new ArrayList<>(columnMap.keySet());
        Collections.sort(sortedColumns);

        for (int col : sortedColumns) {
            ArrayList<int[]> nodes = columnMap.get(col);
            Collections.sort(nodes, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });

            ArrayList<Integer> columnResult = new ArrayList<>();
            for (int[] node : nodes) {
                columnResult.add(node[1]);
            }

            result.add(columnResult);
        }

        return result;
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
        System.out.println(verticalOrder(rootA));
    }
}
