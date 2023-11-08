public class UnsortedDuplicateUnique{

    /* 
     * Given an unsorted array such that;
     *    -> all elements appear twice except one
     *    -> all duplicate will be next to each other
     * 
     * Return the index of single element.
    */

    public static int solve(int[] A){   
        int start = 1;
        int end = A.length - 2;

        while(start <= end){
            System.out.println(start + " " + end);
            int mid = (start = end) / 2;
            if(! (A[mid] == A[mid+1] && (mid%2) == 0) || (A[mid] == A[mid-1] && (mid%2) == 1) ){
                return mid;
            }
            else if(A[mid] == A[mid+1]){
                start = mid+2;
            }
            else{
                end = mid-2;
            }
        }

        return -1;
    }

    public static int solve1(int[] A){
        int val = 0;
        for(int i = 0; i < A.length; i++){
            val = val^A[i];
        }

        int start = 0;
        int end = A.length;
        
        while(start <= end){
            int mid = (start + end) / 2;

            if(A[mid] == val){
                return mid;
            }
            if(A[mid] > val){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {5, 5, 3, 3, 7, 7, 0, 0, 6, 9, 9, 2, 2};
        System.out.println(solve(A));
    }
}
