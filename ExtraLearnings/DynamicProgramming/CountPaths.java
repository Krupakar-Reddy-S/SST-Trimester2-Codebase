import java.util.HashMap;
import java.util.List;

public class CountPaths {

    /* 
     * Count Paths:
     * 
     * Given a 2D grid, count the number of paths from the top left to the bottom right.
     * Given that you can only move right or down and that some cells are blocked.
     * 
    */

    // TC = O(2^(rows + columns)), SC = O(rows + columns)
    public static int countPaths(int[][] grid) {
        return countPaths(grid, 0, 0);
    }

    private static int countPaths(int[][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == -1) {
            return 0;
        }

        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }

    // TC = O(rows*columns), SC = O(rows + columns)
    public static int countpathsOptimised(int[][] grid) {
        return countPathsOptimised(grid, 0, 0, new HashMap<>());
    }

    private static int countPathsOptimised(int[][] grid, int row, int col, HashMap<List<Integer>, Integer> memo) {
        List<Integer> key = List.of(row, col);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        if (row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == -1) {
            return 0;
        }

        int count = countPathsOptimised(grid, row + 1, col, memo) + countPathsOptimised(grid, row, col + 1, memo);

        memo.put(key, count);
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Count Paths Recursive:");
        long start1 = System.currentTimeMillis();
        System.out.println(countPaths(grid));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1 + "ms");

        System.out.println();

        System.out.println("Count Paths Optimised:");
        long start2 = System.currentTimeMillis();
        System.out.println(countpathsOptimised(grid));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + "ms");
    }
}
