public class MaxStairs {

    /* 
     * 
    */

    public static int maxStairs(int N){
        int start = 1;
        int end = N;
        int ans = -1;

        while(start <= end){
            int mid = start + ((end - start)/ 2);
            int val = (mid*(mid+1)) / 2;

            if(val == N){
                return mid;
            }
            else if(val > N){
                end = mid - 1;
            }
            else{
                ans = mid;
                start = mid + 1;
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxStairs(11));
    }
}
