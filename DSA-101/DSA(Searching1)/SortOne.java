import java.util.Arrays;

class SortOne{

    /* 
     * Given an Array of size N,
     * Rearrange the Array such that the last element of the Array reaches its correct position
     * and:
     *      all elements <= last element -> on left of it
     *      all elements > last element -> on rigth of it
    */

    // TC = O(N), SC = O(1)
    public static int[] sortOne(int[] A){
        int last = A[A.length -1];
        
        int ans[] = new int[A.length];
        int start_index = 0;
        int end_index = A.length -1;
        
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] <= last){
                ans[start_index] = A[i];
                start_index++;
            }
            else{
                ans[end_index] = A[i];
                end_index--;
            }
        }

        ans[start_index] = last;

        return ans;
    }

    // TC = O(N), SC + O(1)
    public static void sortOne1(int[] A){
        int last = A[A.length - 1];
        int index = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] <= last){
                int temp = A[i];
                A[i] = A[index];
                A[index] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {9, 8, 1, 6, 5, 11, 4, 7};
        // int ans[] = sortOne(A);

        sortOne1(A);
        System.out.println(Arrays.toString(A));

    }
}
