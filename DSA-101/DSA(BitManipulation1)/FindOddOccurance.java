public class FindOddOccurance {

    /*
     * Companies: Amazon, MS, Adobe, Oyo, Ola ....
     * 
     * Given an Array where all the numbers appear even No. of times exactly,
     * and one number which appers odd No. of times, return that number.
     * 
     */

    // TC = O(N), SC = O(1)
    public static int findOddOccurance(int[] A) {
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int A[] = { 2, 7, 3, 6, 2, 2, 3, 2, 7, 6, 6, 7, 7, 1, 1 };
        System.out.println(findOddOccurance(A));
    }
}
