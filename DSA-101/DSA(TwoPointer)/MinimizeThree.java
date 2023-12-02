import java.util.Arrays;

public class MinimizeThree {

    /* 
     * Companies: Amazon
     * 
     * Given three Sorted Arrays A,B and C
     * Find i, j, k such that:
     * max(A[i], B[j], B[k]) - min(A[i], B[j], C[k]) is minimized
     * 
    */

    // TC = O(N), SC = O(1)
    public static int[] minimizeThree(int[] A, int[] B, int[] C){
        int i = 0;
        int j = 0;
        int k = 0;

        int ansI = 0;
        int ansJ = 0;
        int ansK = 0;

        int minDiff = Integer.MAX_VALUE;

        while(i < A.length && j < B.length && k < C.length){
            int max = maxThree(A[i], B[j], C[k]);
            int min = minThree(A[i], B[j], C[k]);

            int diff = max - min;

            if(diff < minDiff){
                minDiff = diff;
                ansI = i;
                ansJ = j;
                ansK = k;
            }

            if(A[i] == min){
                i++;
            }
            else if(B[j] == min){
                j++;
            }
            else{
                k++;
            }
        }

        return new int[] {ansI, ansJ, ansK };
    }

    public static int maxThree(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static int minThree(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int A[] = {3, 14, 16, 23 };
        int B[] = {-6, 23, 24, 30 };
        int C[] = {-15, 15, 26, 31 };

        System.out.println(Arrays.toString(minimizeThree(A, B, C)));
    }
}
