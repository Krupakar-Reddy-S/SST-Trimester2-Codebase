public class BitPairsDifferenceSum {

    /* 
     * Companies: Google
     * 
     * Given an Array. For every pair of element in the Array.
     * Return the sum of difference between bits of every pairs of elements.
     * 
    */

    // TC = O(N^2 * log(max)), O(1)
    public static int bitPairsDifferenceSum(int[] nums){
        int ans = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int xor = nums[i] ^ nums[j];

                while(xor > 0){
                    ans += (xor & 1);
                    xor /= 2;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int A[] = {1, 3, 5 };
        System.out.println(bitPairsDifferenceSum(A));
    }
}
