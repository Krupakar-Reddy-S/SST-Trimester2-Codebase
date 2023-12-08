public class MinSubArraySumLength {

    /* 
     * Given an Array & a number K
     * Find the minimum length l, such that
     * all SubArrays of length l have sum <= K
     *                 or
     * there is no SubArray with a sum > K.
     * 
    */

    private static boolean check(int[] A, int k, int target) {
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (i >= k) {
                sum -= A[i - k];
            }

            if (sum > target) {
                return false;
            }
        }

        return true;
    }

    public static int solve(int[] A, int B) {
        int start = 1;
        int end = A.length;
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (check(A, mid, B)) {
                result = mid;
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        System.out.println(solve(A, 10));
    }
}
