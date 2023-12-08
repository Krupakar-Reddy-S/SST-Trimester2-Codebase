public class MaxANDvalue {

    /* 
     * Companies: Google
     * 
     * Given an Array of +ve integers,
     * Return the max & value of any pair.
     * i.e. return (A[i], A[j]) where i != j.
     * 
    */

    public static int maxANDvalue(int[] nums){
        int maxAnd = 0, count;

        for(int bit = 31; bit >= 0; bit--){
            count = 0;
            for(int num : nums){
                if((num & (1 << bit)) != 0)
                    count++;
                if(count == 2)
                    break;
            }
            if(count >= 2)
                maxAnd |= (1 << bit);
        }

        return maxAnd;
    }

    public static void main(String[] args) {
        int A[] = {27, 18, 20 };
        System.out.println(maxANDvalue(A)); // expected: 18

        int B[] = {2, 3, 2, 4, 5, 5};
        System.out.println(maxANDvalue(B)); // expected: 7

        int C[] = {1, 1, 2, 2, 3, 4};
        System.out.println(maxANDvalue(C)); // expected: 3

        int D[] = {10, 20, 30, 40};
        System.out.println(maxANDvalue(D)); // expected: 30

        int E[] = {5, 10, 25, 30, 35};
        System.out.println(maxANDvalue(E)); // expected: 31

        int F[] = {6, 13, 19, 24};
        System.out.println(maxANDvalue(F)); // expected: 24

        int G[] = {26, 13, 23, 28, 27, 7, 25 };
        System.out.println(maxANDvalue(G)); // expected: 28
    }
}
