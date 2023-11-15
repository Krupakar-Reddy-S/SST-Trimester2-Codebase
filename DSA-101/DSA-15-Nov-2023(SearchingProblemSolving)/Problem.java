public class Problem {

    /* 
     * Given an Array & a number K
     * Find the minimum length l, such that
     * all SubArrays of length l have sum <= K
     *                 or
     * there is no SubArray with a sum > K.
     * 
    */

    public static boolean isValidLength(int[] A, int mid, int K){
        
    }

    public static int solve(int[] A, int K){
        int start = 0;
        int end = A.length;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isValidLength(A, mid, K)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        System.out.println();
    }
}
