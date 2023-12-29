import java.util.HashMap;

public class SumPossible {

    /* 
     * Sum Possible:
     * 
     * Given an Amount and an Array of numbers,
     * return True if it is possible to form the amount by
     * adding the elements of numbers, else return false.
     * 
     * Note: Any element from numbers can be used multiple times.
     * 
    */

    // TC = O(N^amount), SC = O(amount)
    public static boolean sumPossible(int amount, int[] numbers) {
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        for (int num : numbers) {
            int subAmount = amount - num;

            if (sumPossible(subAmount, numbers)) {
                return true;
            }
        }

        return false;
    }

    // TC = O(N*amount), SC = O(amount)
    public static boolean sumPossibleOptimised(int amount, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        for (int num : numbers) {
            int subAmount = amount - num;

            if (sumPossibleOptimised(subAmount, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }

    public static void main(String[] args) {
        int amount = 500;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        
        System.out.println("Sum Possible Recursive:");
        long start1 = System.currentTimeMillis();
        System.out.println(sumPossible(amount, numbers));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1 + "ms");

        System.out.println();

        System.out.println("Sum Possible Optimised:");
        long start2 = System.currentTimeMillis();
        System.out.println(sumPossibleOptimised(amount, numbers, new HashMap<Integer, Boolean>()));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + "ms");
    }
}
