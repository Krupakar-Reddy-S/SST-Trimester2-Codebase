import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerIndex {

    /* 
     * Given an Array of +ve Integers.
     * For every index i, find the index of nearest 
     * smaller element on th left of i [0, i-1].
     * 
    */

        // TC = O(N), SC = O(N)
        public static int[] nearestSmallerIndex(int[] arr) {
            int[] ans = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
        
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
        
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } 
                else {
                    ans[i] = stack.peek();
                }
        
                stack.push(i);
            }
        
            return ans;
        }

    public static void main(String[] args) {
        int A[] = {4, 2, 5, 10, 8, 2};
        System.out.println(Arrays.toString(nearestSmallerIndex(A))); // Output: [-1, 4, 2, 5, 10, 2]
    }
}
