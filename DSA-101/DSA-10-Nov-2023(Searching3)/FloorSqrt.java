public class FloorSqrt {

    /* 
     * Given a number return the floor(sqrt(N))
    */

    // TC = O(sqrt(N)), SC = O(1)
    public static int floorSqrt1(int N){
        for(int i = 1; i <= N; i++){
            if(i*i <= N && (i+1)*(i+1) > N){
                return i;
            }
        }

        return -1;
    }

    // TC = O(logn), SC = O(1)
    public static int floorSqrt2(int N){
        int start = 0;
        int end = N;
        int ans = -1;

        while( start <= end){
            int mid = ((end - start) / 2 )+ start;
            if((long) mid * mid <= (long) N){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt2(7));
    }
}
