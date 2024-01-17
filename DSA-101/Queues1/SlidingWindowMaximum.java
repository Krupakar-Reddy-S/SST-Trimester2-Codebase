import java.util.Arrays;

public class SlidingWindowMaximum {

    /* 
     * Given an Array A[n], return an Array containing the maximum 
     * element for each and every window(subarray) of size K.
     * 
    */

    // TC: O(N*K), SC: O(1)
    public static int[] slidingWindowMaximum(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n-k+1];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        right[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = arr[i];
            } else {
                left[i] = Math.max(left[i - 1], arr[i]);
            }

            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = arr[j];
            } else {
                right[j] = Math.max(right[j + 1], arr[j]);
            }
        }

        for (int i = 0; i < n - k + 1; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 3, 6, 4, 7, 5, 2, 3};
        int ans[] = slidingWindowMaximum(arr, 4);

        System.out.println(Arrays.toString(ans));
    }
}
