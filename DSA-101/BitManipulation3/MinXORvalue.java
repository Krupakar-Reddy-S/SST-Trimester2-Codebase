import java.util.Arrays;

public class MinXORvalue {

    /* 
     * Given an Array of +ve integers,
     * Find the pair with min XOR value.
     * 
    */

    // TC = O(N^2), SC = O(1)
    public static int[] minXORvalue(int[] nums){
        int minXor = Integer.MAX_VALUE;
        int ans[] = new int[] {-1, -1};

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((nums[i] ^ nums[j]) < minXor){
                    minXor = nums[i] ^ nums[j];
                    ans[0] = nums[i];
                    ans[1] = nums[j];
                }
            }
        }

        return ans;
    }

    // TC = O(NlogN), SC = O(1)
    public static int[] minXORvalue1(int[] nums){
        Arrays.sort(nums);
    
        int minXor = Integer.MAX_VALUE;
        int ans[] = new int[] {-1, -1};
    
        for(int i = 1; i < nums.length; i++){
            int xor = nums[i-1] ^ nums[i];
            if(xor < minXor){
                minXor = xor;
                ans[0] = nums[i-1];
                ans[1] = nums[i];
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int A[] = {7, 3, 11, 10, 6, 2, 3 };
        System.out.println(Arrays.toString(minXORvalue1(A)));  // Expected: [3, 3]

        int B[] = {2, 3, 2, 4, 5, 5};
        System.out.println(Arrays.toString(minXORvalue1(B)));  // Expected: [2, 2]

        int C[] = {1, 1, 2, 2, 3, 4};
        System.out.println(Arrays.toString(minXORvalue1(C)));  // Expected: [1, 1]
    }
}
