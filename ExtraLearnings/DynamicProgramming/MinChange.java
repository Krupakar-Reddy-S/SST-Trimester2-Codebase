import java.util.HashMap;

public class MinChange {

    /* 
     * Min Change:
     * 
     * Given an Amount and an Array of coins,
     * return the minimum number of coins required to form the amount.
     * 
     * Note: Any coin from coins can be used multiple times.
     * 
    */

    // TC = O(N^amount), SC = O(amount)
    public static int minChange(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int minCoins = -1;

        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins);

            if (subCoins != -1) {
                int numCoins = subCoins + 1;

                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }

        }

        return minCoins;
    }

    // TC = O(N*amount), SC = O(amount)
    public static int minChangeOptimised(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = -1;

        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChangeOptimised(subAmount, coins, memo);

            if (subCoins != -1) {
                int numCoins = subCoins + 1;

                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }

        }

        memo.put(amount, minCoins);
        return minCoins;
    }

    public static void main(String[] args) {
        int amount = 60;
        int[] coins = {1, 5, 10, 25};

        System.out.println("Min Change:");
        long start1 = System.currentTimeMillis();
        System.out.println(minChange(amount, coins));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1 + "ms");

        System.out.println();

        System.out.println("Min Change Optimised:");
        long start2 = System.currentTimeMillis();
        System.out.println(minChangeOptimised(amount, coins, new HashMap<Integer, Integer>()));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + "ms");
    }
}
