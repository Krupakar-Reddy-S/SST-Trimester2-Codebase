import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    /* 
     * Given an Array of +ve Integers.
     * For every index i, find the nearest 
     * smaller element on the left of i [0, i-1].
     * 
     * Example:
     * Index:  0  1  2   3  4  5    
     *        [4, 2, 5, 10, 8, 2]
     *        -1 -1  2   5  5 -1
     * 
    */

    // TC = O(N), SC = O(N)
    public static int[] nearestSmallerElement(int[] arr) {
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
    
            stack.push(arr[i]);
        }
    
        return ans;
    }


    public static void main(String[] args) {
        int A[] = {4, 2, 5, 10, 8, 2};
        System.out.println(Arrays.toString(nearestSmallerElement(A))); // Output: [-1, -1, 2, 2, 5, -1]
    }
}
