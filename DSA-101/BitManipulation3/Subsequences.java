import java.util.ArrayList;

public class Subsequences {

    /* 
     * Given an Array. Print all subSequences of the Array.
     * 
    */

    public static ArrayList<ArrayList<Integer>> subSequences(int[] nums){
        ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();
        for(int i = 0; i < (int) Math.pow(2, nums.length); i++){
            ArrayList<Integer> sequence = new ArrayList<>();

            for(int j = 0; j < nums.length; j++){
                if((i & (1 << j))!= 0){
                    sequence.add(nums[j]);
                }
            }

            subsequences.add(sequence);
        }

        return subsequences;
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3 };
        System.out.println(subSequences(A));
    }
}
