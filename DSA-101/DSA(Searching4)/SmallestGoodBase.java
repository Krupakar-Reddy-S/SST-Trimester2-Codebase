public class SmallestGoodBase {

    /* 
     * Given an Integer.
     * Return an integer. Return the smallest good base.
     * 
     * Good Base: thenbase for which n can be represented as all 1's
    */

    // public static boolean goodBase(int N, int base){
    //     while(N > 0){
    //         if(N%base == 1){
    //             N/=base;
    //         }
    //         else{
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // public static int firstGoodBase(int N, int digit){
    //     int start = 2;
    //     int end = N - 1;

    //     while( start <= end){
    //         int mid = start + (end - start)/ 2;
    //         int val = getVal(mid, digit);

    //         if(val < N){

    //         }
    //     }
    // }

    // public static int getVal(int mid, int digit){
    //     int power = 1;
    //     int ans = 1;

    //     for(int i = 1; i < digit; i++){
    //         power *= mid;
    //         ans += power;
    //     }

    //     return ans;
    // }

    // // TC = O(NlogN), SC = O(1)
    // public static int smallestGoodBase(int N){
    //     for(int i = 2; i < N; i++){
    //         if(goodBase(N, i)){
    //             return i;
    //         }
    //     }

    //     return -1;
    // }

    // // TC = O(logN * logN), SC = O(1)
    // public static int smallestGoodBase1(int N){
    //     for(int digit = ((int)(Math.log(N) / Math.log(2)) + 1); digit >= 2; digit--){

    //     }
    // }

    public static void main(String[] args) {
        System.out.println(smallestGoodBase(1000000000000000000L));
    }
}
