public class ThriceUnique{

    /* 
     * Companies: Google
     * 
     * Given an Array where all elements appear
     * thrice except one element which appers once.
     * Find the single number.
     * 
     * Constraint:
     *      -> SC: O(1)
     *      -> Changing Array is not allowed
     * 
    */

    // TC = O(N^2), SC = O(1)
    public static int thriceUnique(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int count = 0;
        
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == nums[i]){
                    count++;
                }
            }

            if(count == 1){
                return nums[i];
            }
        }

        return -1;
    }

    // TC = O(Nlog(max)), SC = O(1)
    public static int thriceUnique1(int [] nums){
        int result = 0;

        for(int i = 0; i < 32; i++){
            int sum = 0;
            int x = (1 << i);

            for(int j = 0; j < nums.length; j++){
                if((nums[j] & x) != 0){
                    sum++;
                }
            }

            if (sum % 3 != 0){
                result |= x;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int A[] = {5, 7, 5, 7, 11, 11, 9, 11, 7, 5 };
        System.out.println(thriceUnique1(A));
    }
}