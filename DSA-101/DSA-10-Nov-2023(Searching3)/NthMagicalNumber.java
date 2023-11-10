public class NthMagicalNumber {

    /* 
     * Given 3 numbers N, A, B, 
     * return the Nth number divisible by A or B.
    */

    // TC = O(N), SC= O(1)
    public static int nthMagicalNumber1(int N, int A, int B){
        int count = 0;
        int i = 1;

        while(count < N){
            if(i%A == 0 || i%B == 0){
                count ++;
            }

            i++;
        }

        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber1(5, 2, 3));
    }
}
