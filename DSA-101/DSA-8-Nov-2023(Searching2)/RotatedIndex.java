public class RotatedIndex {

    /* 
     * Given an array which is rotated find a target
     * (all elements are distinct)
    */

    public static int pivot(int[] A){
        int start = 0;
        int end = A.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(A[mid] >= A[0]){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int A[] = {10, 20, 30, -1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(pivot(A));
    }
}
