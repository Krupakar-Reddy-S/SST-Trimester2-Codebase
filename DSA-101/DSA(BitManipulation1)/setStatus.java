public class setStatus {

    /* 
     * 
    */

    public static boolean isBitSet(int N, int i){
        return (N >> i & 1) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isBitSet(21, 2));
    }
}
