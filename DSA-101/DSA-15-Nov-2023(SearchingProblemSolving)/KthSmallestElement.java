public class KthSmallestElement {
    /* 
     * Given an Array,
     * Find the Kth min of the Array. A[k-1] in sorted array.
     * 
     * Constraints:
     *     SC = O(1)
     *     Array cannot be changed.
     *     1 <= A[i] <= 10^9
     * 
    */

    public static int count(int[] A, int mid){
        int count = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] <= mid){
                count++;
            }
        }

        return count;
    }

    public static int KthSmallest(int[] A, int K){
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int ans = -1;

        for(int i = 0; i < A.length; i++){
            if(A[i] < start){
                start = A[i];
            }
            if(A[i] > end){
                end = A[i];
            }
        }

        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(count(A, mid) >= K){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int A[] = {7, 9, 12, 15, 15, 18, 18};

        System.out.println(KthSmallest(A, 5));
    }
}
