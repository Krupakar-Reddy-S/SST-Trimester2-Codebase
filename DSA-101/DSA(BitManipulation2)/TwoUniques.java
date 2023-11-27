import java.util.Arrays;

public class TwoUniques {

    /* 
     * Given an Array of +ve no. Every element
     * appears two times except 2 elements
     * which appear exactly once.
     * 
    */

    // TC = O(N), SC = O(1)
    public static int[] twoUniques(int[] nums){
        int xor = 0;

        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        
        int setBit = xor & ~(xor-1);
        int num1 = 0, num2 = 0;

        for(int i = 0; i < nums.length; i++){
            if((nums[i] & setBit) > 0){
                num1 ^= nums[i];
            }
            else{
                num2 ^= nums[i];
            }
        }

        return new int[] {num1, num2};
    }

    public static void main(String[] args) {
        int A[] = {4, 9, 7, 9 , 1, 4 };
        System.out.println(Arrays.toString(twoUniques(A)));
    }
}
