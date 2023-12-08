public class TwoSum {

    /* 
     * Companies: Amazon, Facebook
     * 
     * Given a Sorted Array and a No. K,
     * check if there exists a pair of elements,
     * A[i], A[j] such that A[i] + A[j] = K (i != j)
     * 
    */

    // TC = O(N), SC = O(1)
    public static boolean twoSum(int[] A, int k){
        int i = 0;
        int j = A.length - 1;

        while(i != j){
            if(A[i] + A[j] == k){
                return true;
            }
            else if(A[i] + A[j] > k){
                j--;
            }
            else{
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int A[] = {3, 7, 8, 12, 19 };
        System.out.println(twoSum(A, 15));
    }
}
