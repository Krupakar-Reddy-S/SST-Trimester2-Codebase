public class LocalMinima {

    /* 
     * Given an unsorted array. (all elements are distinct)
     * Return any local minima. A[i] is a local minima if A[i] < A[i+1] and A[i] < A[i-1]
    */

    // TC = O(logN), SC = O(1)
    public static int localMinima(int[] A){
        if(A[0] < A[1]){
            return 0;
        }
        else if(A[A.length-1] < A[A.length-2]){
            return A.length-1;
        }
        else{
            int start = 1;
            int end = A.length - 2;

            while(start <= end){
                int mid = (start + end) / 2;

                if(A[mid] < A[mid+1] && A[mid] < A[mid-1]){
                    return mid;
                }
                else if(A[mid-1] < A[mid+1]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int A[] = {10, 3, 2, 6, 1, 7, 5};
        System.out.println(localMinima(A));
    }
}
