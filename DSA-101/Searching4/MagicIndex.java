public class MagicIndex {

    /* 
     * Given an sorted array of distinct elements.
     * Find any magic index of this array.
     *          |
     *          --> A[i] == i
    */

    // TC = O(N), SC = O(1)
    public static int magicIndex(int[] A){
        for(int i = 0; i < A.length; i++){
            if(A[i] == i){
                return i;
            }
        }

        return -1;
    }

    // TC = O(logN), SC = O(1)
    public static int magicIndex1(int[] A){
        int start = 0;
        int end = A.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(A[mid] == mid){
                return mid;
            }
            else if(A[mid] < mid){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {-1, 0, 1, 2, 4, 10 };
        System.out.println(magicIndex1(A));
    }
}
