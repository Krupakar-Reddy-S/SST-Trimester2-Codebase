import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MaxPathSum {

    /* 
     * Max Path Sum:
     * 
     * Given a 2D array of numbers, find the maximum sum of a path from the top-left cell to the bottom-right cell.
     * Given that you can only move right or down.
     * 
    */

    // TC = O(2^(rows + columns)), SC = O(rows + columns)
    public static int maxPathSum(int[][] grid) {
        return maxPathSum(0, 0, grid);
    }

    private static int maxPathSum(int row, int col, int[][] grid) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        int right = maxPathSum(row, col + 1, grid);
        int down = maxPathSum(row + 1, col, grid);

        return grid[row][col] + Math.max(right, down);
    }

    // TC = O(rows*columns), SC = O(rows + columns)
    public static int maxPathSumOptimised(int[][] grid) {
        return maxPathSumOptimised(0, 0, grid, new HashMap<>());
    }

    private static int maxPathSumOptimised(int row, int col, int[][] grid, HashMap<List<Integer>, Integer> memo) {
        List<Integer> key = List.of(row, col);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MIN_VALUE;
        }

        int right = maxPathSumOptimised(row, col + 1, grid, memo);
        int down = maxPathSumOptimised(row + 1, col, grid, memo);

        int max = grid[row][col] + Math.max(right, down);

        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[15][15];
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                grid[i][j] = rand.nextInt(51);
            }
        }

        System.out.println("Max Path Sum Recursive:");
        long start1 = System.currentTimeMillis();
        System.out.println(maxPathSum(grid));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1 + "ms");

        System.out.println();

        System.out.println("Max Path Sum Optimised:");
        long start2 = System.currentTimeMillis();
        System.out.println(maxPathSumOptimised(grid));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + "ms");
    }
}
