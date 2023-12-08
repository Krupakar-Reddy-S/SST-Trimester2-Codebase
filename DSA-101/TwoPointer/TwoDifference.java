public class TwoDifference {

    /* 
     * Given a Sorted Array and a No. K(>= 0),
     * check if there exists a pair of elements,
     * A[i], A[j] such that A[i] - A[j] = K (i != j)
     * 
    */

    // TC = O(N), SC = O(1)
    public static boolean twoDifference(int[] A, int k){
        int i = 0;
        int j = A.length - 1;

        while(i < A.length && j >= 0){
            if(i != j && abs(A[i] - A[j]) == k){
                return true;
            }
            else if(abs(A[i] - A[j]) > k){
                j--;
            }
            else{
                i++;
            }

            // System.out.println(A[i] + " " + A[j]);
        }

        return false;
    }

    // TC = O(N), SC = O(1)
    public static boolean twoDifference1(int[] A, int k){
        int n = A.length;
        int i = 1;
        int j = 0;

        while(i < n){
            if(A[i] - A[j] == k){
                return true;
            }
            else if(A[i] - A[j] > k){
                j++;
            }
            else{
                i++;
            }
        }

        return false;
    }

    public static int abs(int num){
        return num > 0 ? num : -num;
    }

    public static void main(String[] args) {
        int A[] = {0, 1, 2, 3, 25 };
        System.out.println(twoDifference(A, 25));
    }
}
