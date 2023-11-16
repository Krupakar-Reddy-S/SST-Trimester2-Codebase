public class PaintersPartitionProblem {

    /* 
     * Given N tasks and K workers.
     * A[N] is the Time taken for each task.
     * Find min time in which all tasks can be done.
     * 
     * Target: Sum of SubArrays (minimize the max)
     * 
    */

    public static int paintersRequired(int[] C, int timeLimit) {
        int painters = 1;
        int currentBoardLength = 0;

        for (int length : C) {
            if (currentBoardLength + length > timeLimit) {
                painters++;
                currentBoardLength = 0;
            }

            currentBoardLength += length;
        }

        return painters;
    }

    public static int paint(int A, int B, int[] C) {
        int low = 0;
        int high = 0;
        int mod = 10000003;

        for (int length : C) {
            high += length;
            low = Math.max(low, length);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int paintersRequired = paintersRequired(C, mid);

            if (paintersRequired <= A) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long result = ((long) low * B) % mod;

        return (int) result;
    
    }

    public static void main(String[] args) {
        int C[] = {1, 8, 11, 3 };
        System.out.println(paint(10, 1, C));
    }
}
