public class ToogleBits {

    /* 
     * Given a no. N toggle all the bits.
     *      
     *      set -> unset
     *      unset -> set
     * 
    */

    // TC = O(1), SC = O(1)
    public static int toogleBits(int N, int i){
        int A = 1;
        A <<= i;

        return A ^ N;
    }

    public static void main(String[] args) {
        System.out.println(toogleBits(10, 1));
    }
}
