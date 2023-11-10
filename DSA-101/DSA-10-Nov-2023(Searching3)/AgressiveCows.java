public class AgressiveCows {

    /* 
     * 
     * 
     * 
     * Return the max vaue of the minimum distance of any two cows.
     * 
     * target -> distance between the closest pair of cows.
     * search space -> s: 1
     *                 e: A[N-1] - A[0]
     * 
     * In check() we return true if it is possible to maintain a
     * minumum distance of dist while keeping K cows in array A.
    */

    public static boolean check(int[] A, int k, int dist){
        int prevPos = A[0];
        int cowsPlaced = 1;

        for(int i = 0; i < A.length; i++){
            if(A[i] - prevPos >= dist){
                cowsPlaced++;
                prevPos = A[i];
            }

            if(cowsPlaced == k){
                return true;
            }
        }

        return false;
    }

    // TC = O(NlogN), SC = O(1)
    public static int agressiveCows(int[] A, int k){
        int start = 1;
        int end = A[A.length-1] - A[0];
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(check(A, k, mid)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        System.out.println(agressiveCows(A, 2));
    }
}
