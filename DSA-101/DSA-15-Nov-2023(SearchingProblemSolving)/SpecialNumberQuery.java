import java.util.Arrays;

public class SpecialNumberQuery {

    /* 
     * Given an Array A[N] & Q queries(L,R)
     * Find the minimum index i in the rannge [L,R]
     * such that A[i] is a special No. i.e. Sum of digits < 15
     * 
    */

    // TC = O(N^2), SC = O(N)
    public static int SumOfDigits(int num){
        if(num == 0){
            return 1;
        }
        else{
            int sum = 0;
            while(num > 0){
                sum += num%10;
                num/=10;
            }

            return sum;
        }
    }

    public static int[] solve(int[] A, int[][] Q){
        int specials[] = new int[A.length];

        for(int i = 0; i < A.length; i++){
            int sumOfNum = SumOfDigits(A[i]);

            if(sumOfNum < 15){
                specials[i] = sumOfNum;
            }
            else{
                specials[i] = -1;
            }

        }

        int ans[] = new int[Q.length];

        for(int i = 0; i < Q.length; i++){
            int start = Q[i][0];
            int end = Q[i][1];
            int minSpecial = start;

            for(int j = start; j <= end; j++){
                if(A[minSpecial] > A[j]){
                    minSpecial = j;
                    break;
                }
            }

            if(specials[minSpecial] == -1){
                ans[i] = -1;
            }
            else{
                ans[i] = minSpecial;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int A[] = {3, 15, 99, 178, 973, 16, 387, 192};
        int Q[][] = {{0,3}, {4,7}, {1,5}, {3,4}};

        System.out.println(Arrays.toString(solve(A, Q)));
    }
}
